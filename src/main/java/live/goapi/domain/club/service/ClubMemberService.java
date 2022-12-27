package live.goapi.domain.club.service;

import live.goapi.domain.api_key.exception.MisMatchRandomKeyException;
import live.goapi.domain.api_key.facade.ApiKeyFacade;
import live.goapi.domain.club.entity.Club;
import live.goapi.domain.club.exception.ClubNotFoundException;
import live.goapi.domain.club.presentation.dto.request.RequestClub;
import live.goapi.domain.club.presentation.dto.request.RequestClubName;
import live.goapi.domain.club.presentation.dto.response.ResponseClub;
import live.goapi.domain.club.repository.ClubRepository;
import live.goapi.domain.student.entity.Student;
import live.goapi.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClubMemberService {

    private final ClubRepository clubRepository;
    private final ApiKeyFacade apiKeyFacade;

    public List<ResponseClub> getClubs(RequestClub request) {

        if(!request.getApiKey().equals(apiKeyFacade.getCurrentApiKey())) {
            throw new MisMatchRandomKeyException("인증키가 일치하지 않습니다.");
        }

        List<Club> clubList = clubRepository.findAll();
        List<ResponseClub> response = new ArrayList<>();

        for (Club club : clubList) {
            List<String> clubStudentNameList = makeClubStudentNameList(club.getStudents());
            response.add(ResponseClub
                    .builder()
                    .clubName(club.getClubName())
                    .clubStudentName(clubStudentNameList)
                    .build());
        }

        return response;
    }

    public ResponseClub getClubByClubName(RequestClubName request) {
        if(!request.getApiKey().equals(apiKeyFacade.getCurrentApiKey())) {
            throw new MisMatchRandomKeyException("인증키가 일치하지 않습니다.");
        }

        Club findClub = clubRepository.findByClubName(request.getClubName())
                .orElseThrow(() -> new ClubNotFoundException("존재하지 않는 전공동아리 입니다."));

        List<String> clubStudentNameList = makeClubStudentNameList(findClub.getStudents());

        return ResponseClub.
                builder()
                .clubName(findClub.getClubName())
                .clubStudentName(clubStudentNameList)
                .build();

    }

    private List<String> makeClubStudentNameList(List<Student> students) {
        List<String> clubStudentName = new ArrayList<>();
        for (Student student : students) {
            clubStudentName.add(student.getStudentName());
        }

        return clubStudentName;
    }
}
