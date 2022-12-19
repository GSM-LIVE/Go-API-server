package live.goapi.domain.auth.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ExistsEmailException extends RuntimeException{

    private final ErrorCode errorCode;

    public ExistsEmailException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_EMAIL;
    }
}
