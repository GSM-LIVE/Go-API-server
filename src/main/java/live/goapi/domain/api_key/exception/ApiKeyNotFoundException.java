package live.goapi.domain.api_key.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ApiKeyNotFoundException extends RuntimeException{

    private final ErrorCode errorCode;

    public ApiKeyNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.APIKEY_NOT_FOUND;
    }
}
