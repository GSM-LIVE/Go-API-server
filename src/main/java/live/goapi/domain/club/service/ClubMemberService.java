package live.goapi.domain.club.service;

import live.goapi.domain.club.entity.Club;
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

    public List<ResponseClub> getClubs() {
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
