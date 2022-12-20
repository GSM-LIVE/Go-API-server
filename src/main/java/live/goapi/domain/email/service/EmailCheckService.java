package live.goapi.domain.email.service;

import live.goapi.domain.email.entity.EmailAuth;
import live.goapi.domain.email.exception.MisMatchAuthCodeException;
import live.goapi.domain.email.repository.EmailAuthRepository;
import live.goapi.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmailCheckService {

    private final EmailAuthRepository emailAuthRepository;

    @Transactional(rollbackFor = Exception.class)
    public void checkEmail(String email , String authKey) {
        EmailAuth emailAuthEntity = emailAuthRepository.findById(email)
                .orElseThrow(()-> new MemberNotFoundException("유저를 찾을 수 없습니다."));
        checkAuthKey(emailAuthEntity,authKey);
        emailAuthEntity.updateAuthentication(true);
        emailAuthRepository.save(emailAuthEntity);
    }

    private void checkAuthKey(EmailAuth emailAuthEntity, String authKey) {
        if(!Objects.equals(emailAuthEntity.getRandomValue(), authKey)){
            throw new MisMatchAuthCodeException("인증번호가 일치하지 않습니다.");
        }
    }
}
