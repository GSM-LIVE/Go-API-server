package live.goapi.domain.api_key.facade;

import live.goapi.domain.api_key.entity.ApiKey;
import live.goapi.domain.api_key.repository.ApiKeyRepository;
import live.goapi.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiKeyFacade {

    private final ApiKeyRepository apiKeyRepository;
    private final MemberFacade memberFacade;

    public String getCurrentApiKey() {
        ApiKey apiKey = memberFacade.getCurrentMember().getApiKey();
        return apiKey.getRandomKey();
    }
}
