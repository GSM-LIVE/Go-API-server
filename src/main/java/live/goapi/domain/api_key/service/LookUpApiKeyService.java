package live.goapi.domain.api_key.service;

import live.goapi.domain.api_key.exception.ApiKeyNotFoundException;
import live.goapi.domain.api_key.facade.ApiKeyFacade;
import live.goapi.domain.api_key.presentation.dto.response.ApiKeyResponse;
import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.exception.MemberNotFoundException;
import live.goapi.domain.member.facade.MemberFacade;
import live.goapi.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LookUpApiKeyService {

    private final ApiKeyFacade apiKeyFacade;
    private final MemberRepository memberRepository;

    public ApiKeyResponse lookUpApiKey() {
        String currentApiKey = apiKeyFacade.getCurrentApiKey();

        if (currentApiKey.isEmpty()) {
            throw new ApiKeyNotFoundException("인증키가 존재하지 않습니다.");
        }

        return ApiKeyResponse
                .builder()
                .randomKey(currentApiKey)
                .build();
    }

    public ApiKeyResponse lookUpApiKeyByMemberName(String name) {
        Optional<Member> member = memberRepository.findByName(name);

        if(member.isEmpty()) {
            throw new MemberNotFoundException("존재하지 않는 회원입니다.");
        }

        return ApiKeyResponse.builder()
                .randomKey(member.get().getApiKey().getRandomKey())
                .build();
    }
}
