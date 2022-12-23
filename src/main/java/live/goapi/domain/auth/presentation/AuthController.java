package live.goapi.domain.auth.presentation;

import live.goapi.domain.auth.presentation.dto.dto.request.MemberLoginRequest;
import live.goapi.domain.auth.presentation.dto.dto.request.MemberSignUpRequest;
import live.goapi.domain.auth.presentation.dto.dto.response.NewTokenResponse;
import live.goapi.domain.auth.presentation.dto.dto.response.TokenResponse;
import live.goapi.domain.auth.service.MemberLoginService;
import live.goapi.domain.auth.service.MemberSignUpService;
import live.goapi.domain.auth.service.TokenReissueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberSignUpService memberSignUpService;
    private final MemberLoginService memberLoginService;
    private final TokenReissueService tokenReissueService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid MemberSignUpRequest signUpMember) {
        memberSignUpService.signUp(signUpMember);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid MemberLoginRequest loginMember) {
        TokenResponse data = memberLoginService.login(loginMember);
        return new ResponseEntity<>(data , HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<NewTokenResponse> reIssueToken(@RequestHeader("RefreshToken") String token) {
        NewTokenResponse reIssueToken = tokenReissueService.tokenReissue(token);
        return new ResponseEntity<>(reIssueToken, HttpStatus.OK);
    }

}
