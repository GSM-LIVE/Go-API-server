package live.goapi.domain.club.presentation;

import live.goapi.domain.club.presentation.dto.request.RequestClub;
import live.goapi.domain.club.presentation.dto.request.RequestClubName;
import live.goapi.domain.club.presentation.dto.response.ResponseClub;
import live.goapi.domain.club.service.ClubMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ClubMemberService clubMemberService;

    @PostMapping
    public ResponseEntity<List<ResponseClub>> getClubList(@RequestBody @Valid RequestClub request) {
        List<ResponseClub> response = clubMemberService.getClubs(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/name")
    public ResponseEntity<ResponseClub> getClubByName(@RequestBody @Valid RequestClubName request) {
        ResponseClub response = clubMemberService.getClubByClubName(request);
        return ResponseEntity.ok(response);
    }
}
