package live.goapi.domain.club.presentation;

import live.goapi.domain.auth.presentation.dto.dto.ClubMemberRequest;
import live.goapi.domain.club.service.ClubMemberService;
import live.goapi.domain.student.presentation.dto.response.ResponseStudent;
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

    @PostMapping("/student")
    public ResponseEntity<List<ResponseStudent>> getClubStudents(@Valid @RequestBody ClubMemberRequest request) {
        List<ResponseStudent> clubStudents = clubMemberService.getClubStudents(request);
        return new ResponseEntity<>(clubStudents, HttpStatus.OK);
    }
}
