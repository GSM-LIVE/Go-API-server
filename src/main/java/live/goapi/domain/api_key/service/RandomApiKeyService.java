package live.goapi.domain.api_key.service;

import live.goapi.domain.api_key.entity.ApiKey;
import live.goapi.domain.api_key.exception.ExistsRandomKeyException;
import live.goapi.domain.api_key.presentation.dto.response.ApiKeyResponse;
import live.goapi.domain.api_key.repository.ApiKeyRepository;
import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.facade.MemberFacade;
import live.goapi.domain.survey.exception.AlreadyWriteSurveyException;
import live.goapi.domain.survey.exception.NotWriteSurveyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    private final MemberFacade memberFacade;

    @Transactional
    public ApiKeyResponse execute() {
        String randomApiKey = getRandomApiKey();
        Member member = memberFacade.getCurrentMember();

        if(member.isApiKeyAuthenticated()) {
            throw new ExistsRandomKeyException("이미 랜덤키를 발급했습니다.");
        }

        if(!member.isSurveyAuthenticated()) {
            throw new NotWriteSurveyException("아직 설문을 진행하지 않은 계정입니다.");
        }

        apiKeyRepository.save(ApiKey
                .builder()
                .randomKey(randomApiKey)
                .build());

        member.updateApiKey(apiKeyRepository.findByRandomKey(randomApiKey).get());
        member.updateApiKeyAuthenticated(true);

        return ApiKeyResponse
                .builder()
                .randomKey(randomApiKey)
                .build();
    }

    private String getRandomApiKey() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 16;

        Random random = new Random();
        String randomKey = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return randomKey;
    }
}
