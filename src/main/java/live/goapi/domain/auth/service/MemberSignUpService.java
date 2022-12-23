package live.goapi.domain.auth.service;

import live.goapi.domain.auth.exception.ExistsEmailException;
import live.goapi.domain.auth.exception.NotVerifyEmailException;
import live.goapi.domain.auth.presentation.dto.request.MemberSignUpRequest;
import live.goapi.domain.email.entity.EmailAuth;
import live.goapi.domain.email.repository.EmailAuthRepository;
import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.repository.MemberRepository;
import live.goapi.global.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final EmailAuthRepository emailAuthRepository;

    @Transactional(rollbackFor = Exception.class)
    public void signUp(MemberSignUpRequest signUpMember) {
        if(memberRepository.existsByEmail(signUpMember.getEmail()))
            throw new ExistsEmailException("이미 존재하는 이메일입니다.");

        EmailAuth emailAuth = emailAuthRepository.findById(signUpMember.getEmail())
                .orElseThrow(() -> new NotVerifyEmailException("인증되지 않은 이메일입니다."));

        if(!emailAuth.getAuthentication()){
            throw new NotVerifyEmailException("인증되지 않은 이메일입니다.");
        }

        Member member = Member
                .builder()
                .email(signUpMember.getEmail())
                .password(passwordEncoder.encode(signUpMember.getPassword()))
                .name(signUpMember.getName())
                .studentNumber(signUpMember.getStudentNumber())
                .major(signUpMember.getMajor())
                .role(Role.from(signUpMember.getRole()))
                .build();

        memberRepository.save(member);
    }
}
