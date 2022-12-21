package live.goapi.domain.api_key.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchRandomKeyException extends RuntimeException {

    private final ErrorCode errorCode;

    public MisMatchRandomKeyException(String message){
        super(message);
        this.errorCode = ErrorCode.MISMATCH_API_KEY;
    }
}
