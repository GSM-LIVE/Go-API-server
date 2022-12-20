package live.goapi.domain.club.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ClubNotFoundException extends RuntimeException{

    private final ErrorCode errorCode;

    public ClubNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.
    }
}
