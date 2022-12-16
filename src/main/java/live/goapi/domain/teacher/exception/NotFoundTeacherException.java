package live.goapi.domain.teacher.exception;

import live.goapi.global.exception.ErrorCode;
import live.goapi.global.exception.collection.BasicException;
import lombok.Getter;

@Getter
public class NotFoundTeacherException extends BasicException {
    private final ErrorCode errorCode;

    public NotFoundTeacherException(String message) {
        super(message);
        errorCode = ErrorCode.TEACHER_NOT_FOUND;
    }
}
