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
        if(request.getCurrentPassword().equals(member.getPassword())){
                member.updatePassword(passwordEncoder.encode(request.getNewPassword()));
        }
    }
}
