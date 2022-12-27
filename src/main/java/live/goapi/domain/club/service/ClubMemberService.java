package live.goapi.domain.club.service;

import live.goapi.domain.api_key.exception.MisMatchRandomKeyException;
import live.goapi.domain.api_key.facade.ApiKeyFacade;
import live.goapi.domain.club.entity.Club;
import live.goapi.domain.club.presentation.dto.request.RequestClub;
import live.goapi.domain.club.presentation.dto.response.ResponseClub;
import live.goapi.domain.club.repository.ClubRepository;
import live.goapi.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClubMemberService {

    private final ClubRepository clubRepository;
    private final StudentRepository studentRepository;
    private final ApiKeyFacade apiKeyFacade;

    public List<ResponseClub> getClubs(RequestClub request) {

        if(!request.getApiKey().equals(apiKeyFacade.getCurrentApiKey())) {
            throw new MisMatchRandomKeyException("인증키가 일치하지 않습니다.");
        }

        List<Club> clubList = clubRepository.findAll();
        List<ResponseClub> response = new ArrayList<>();

        for (Club club : clubList) {
            response.add(ResponseClub
                    .builder()
                    .clubName(club.getClubName())
                    .build());
        }

        return response;
    }
}
