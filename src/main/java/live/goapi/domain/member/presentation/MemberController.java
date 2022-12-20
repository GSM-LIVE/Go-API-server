package live.goapi.domain.member.presentation;

import live.goapi.domain.member.presentation.dto.request.MemberChangePasswordRequest;
import live.goapi.domain.member.service.MemberChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberChangePasswordService memberChangePasswordService;

    @PatchMapping("/change-pw")
    public ResponseEntity<Void> changePassword(@RequestBody @Valid MemberChangePasswordRequest request) {
        memberChangePasswordService.changePassword(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
