package live.goapi.domain.api_key.service;

import live.goapi.domain.api_key.exception.MisMatchRandomKeyException;
import live.goapi.domain.api_key.facade.ApiKeyFacade;
import live.goapi.domain.api_key.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    private final ApiKeyFacade apiKeyFacade;

    public void checkApiKey(String memberRandomKey) {
        String currentApiKey = apiKeyFacade.getCurrentApiKey();

        if(!memberRandomKey.equals(currentApiKey)) {
            throw new MisMatchRandomKeyException("인증키가 일치하지 않습니다.");
        }
    }
}
