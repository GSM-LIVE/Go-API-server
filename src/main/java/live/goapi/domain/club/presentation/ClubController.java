package live.goapi.domain.club.presentation;

import live.goapi.domain.club.presentation.dto.response.ResponseClub;
import live.goapi.domain.club.service.ClubMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ClubMemberService clubMemberService;

    @PostMapping
    public ResponseEntity<List<ResponseClub>> getClubList() {
        List<ResponseClub> response = clubMemberService.getClubs();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
