package live.goapi.domain.auth.service;

import live.goapi.domain.auth.exception.ExistsEmailException;
import live.goapi.domain.auth.presentation.dto.request.MemberSignUpRequest;
import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    public void signUp(MemberSignUpRequest signUpMember) {
        if(memberRepository.existsByEmail(signUpMember.getEmail()))
            throw new ExistsEmailException("이미 존재하는 이메일입니다.");

        Member member = Member
                .builder()
                .email(signUpMember.getEmail())
                .password(passwordEncoder.encode(signUpMember.getPassword()))
                .name(signUpMember.getName())
                .studentNumber(signUpMember.getStudentNumber())
                .major(signUpMember.getMajor())
                .build();

        memberRepository.save(member);
    }
}
