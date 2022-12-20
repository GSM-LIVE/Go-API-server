package live.goapi.domain.student.exception;

import live.goapi.global.exception.ErrorCode;
import live.goapi.global.exception.collection.BasicException;
import lombok.Getter;

@Getter
public class NotFoundStudentException extends BasicException {

    private final ErrorCode errorCode;

    public NotFoundStudentException(String message) {
        super(message);
        errorCode = ErrorCode.TEACHER_NOT_FOUND;
    }
}
