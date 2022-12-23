package live.goapi.domain.auth.service;

import live.goapi.domain.auth.entity.RefreshToken;
import live.goapi.domain.auth.exception.RefreshTokenNotFoundException;
import live.goapi.domain.auth.presentation.dto.dto.response.NewTokenResponse;
import live.goapi.domain.auth.repository.RefreshTokenRepository;
import live.goapi.global.security.exception.TokenNotValidException;
import live.goapi.global.security.jwt.JwtTokenProvider;
import live.goapi.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenReissueService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Transactional(rollbackFor = Exception.class)
    public NewTokenResponse tokenReissue(String requestToken) {
        String email = jwtTokenProvider.getUserEmail(requestToken, jwtProperties.getRefreshSecret());
        RefreshToken token = refreshTokenRepository.findById(email)
                .orElseThrow(() -> new RefreshTokenNotFoundException("리프레시 토큰을 찾을 수 없습니다."));

        if(!token.getToken().equals(requestToken)) {
            throw new TokenNotValidException("검증되지 않은 토큰입니다.");
        }

        String accessToken = jwtTokenProvider.generatedAccessToken(email);
        String refreshToken = jwtTokenProvider.generatedRefreshToken(email);
        ZonedDateTime expiredAt = jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret());
        token.exchangeRefreshToken(refreshToken);
        refreshTokenRepository.save(token);

        return NewTokenResponse
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .build();
    }
}
