package live.goapi.domain.member.facade;

import live.goapi.domain.member.entity.Member;
import live.goapi.domain.member.exception.MemberNotFoundException;
import live.goapi.domain.auth.exception.PasswordMismatchException;
import live.goapi.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member getCurrentMember() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException("회원을 찾을 수 없습니다."));
    }

    public void checkPassword(Member member, String password) {
        if(!passwordEncoder.matches(password, member.getPassword())) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }
    }
    public Long getUserId() {
        return getCurrentMember().getMemberId();
    }
}

