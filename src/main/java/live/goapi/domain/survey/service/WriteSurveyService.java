package live.goapi.domain.survey.service;

import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.facade.MemberFacade;
import live.goapi.domain.survey.entity.Survey;
import live.goapi.domain.survey.exception.AlreadyWriteSurveyException;
import live.goapi.domain.survey.presentation.dto.WriteSurveyRequest;
import live.goapi.domain.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteSurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberFacade memberFacade;

    @Transactional(rollbackFor = Exception.class)
    public void writeSurvey(WriteSurveyRequest request) {

        Member currentMember = memberFacade.getCurrentMember();

        if (currentMember.isSurveyAuthenticated()) {
            throw new AlreadyWriteSurveyException("이미 설문조사를 완료한 회원입니다.");
        }

        Survey survey = Survey
                .builder()
                .groupName(request.getGroupName())
                .projectName(request.getProjectName())
                .purpose(request.getPurpose())
                .description(request.getDescription())
                .build();


        surveyRepository.save(survey);
    }
}
