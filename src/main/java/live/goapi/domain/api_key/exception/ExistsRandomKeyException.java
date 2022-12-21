package live.goapi.domain.api_key.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ExistsRandomKeyException extends RuntimeException{

    private final ErrorCode errorCode;

    public ExistsRandomKeyException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_KEY;
    }
}
