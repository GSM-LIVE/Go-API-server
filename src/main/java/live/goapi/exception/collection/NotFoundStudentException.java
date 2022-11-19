package live.goapi.exception.collection;

import live.goapi.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundStudentException extends BasicException {

    private final ErrorCode errorCode;

    public NotFoundStudentException(String message) {
        super(message);
        errorCode = ErrorCode.TEACHER_NOT_FOUND;
    }
}
