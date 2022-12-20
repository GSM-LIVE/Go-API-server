package live.goapi.domain.email.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AuthCodeExpiredException extends RuntimeException{
    private final ErrorCode errorCode;

    public AuthCodeExpiredException(String message) {
        super(message);
        this.errorCode = ErrorCode.EXPIRE_EMAIL_CODE
    }
}
