package live.goapi.domain.member.service;

import live.goapi.domain.auth.exception.NotVerifyEmailException;
import live.goapi.domain.member.presentation.dto.request.MemberChangePasswordRequest;
import live.goapi.domain.email.entity.EmailAuth;
import live.goapi.domain.email.repository.EmailAuthRepository;
import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberChangePasswordService {
    private final MemberFacade memberFacade;
    private final PasswordEncoder passwordEncoder;
    private final EmailAuthRepository emailAuthRepository;

    @Transactional(rollbackFor = Exception.class)
    public void changePassword(MemberChangePasswordRequest request) {
        Member member = memberFacade.getCurrentMember();
        if(request.getPassword().equals(member.getPassword())){
            if(validateAuthentication((member.getEmail()))) {
                member.updatePassword(passwordEncoder.encode(request.getPassword()));
            }
        }
    }

    private Boolean validateAuthentication(String email) {
        EmailAuth emailAuth = emailAuthRepository.findById(email).orElseThrow(()-> new NotVerifyEmailException("이메일이 인증되지 않았습니다."));
        if(!emailAuth.getAuthentication()) {
            throw new NotVerifyEmailException("이메일이 인증되지 않았습니다.");
        }
        return true;
    }
}
