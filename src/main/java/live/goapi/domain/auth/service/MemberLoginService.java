package live.goapi.domain.auth.service;

import live.goapi.domain.auth.entity.RefreshToken;
import live.goapi.domain.auth.presentation.dto.request.MemberLoginRequest;
import live.goapi.domain.auth.presentation.dto.response.TokenResponse;
import live.goapi.domain.auth.repository.RefreshTokenRepository;
import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.exception.MemberNotFoundException;
import live.goapi.domain.member.facade.MemberFacade;
import live.goapi.domain.member.repository.MemberRepository;
import live.goapi.global.security.jwt.JwtTokenProvider;
import live.goapi.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final MemberRepository memberRepository;
    private final MemberFacade memberFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional(rollbackFor = Exception.class)
    public TokenResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다."));

        memberFacade.checkPassword(member, request.getPassword());

        String accessToken = jwtTokenProvider.generatedAccessToken(request.getEmail());
        String refreshToken = jwtTokenProvider.generatedRefreshToken(request.getEmail());
        RefreshToken entityToRedis = new RefreshToken(request.getEmail(), refreshToken, jwtTokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());
        refreshTokenRepository.save(entityToRedis);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }
}
