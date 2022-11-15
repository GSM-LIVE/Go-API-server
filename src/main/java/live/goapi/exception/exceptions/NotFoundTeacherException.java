package live.goapi.exception.exceptions;

import live.goapi.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotFoundTeacherException extends BasicException{
    private final ErrorCode errorCode;

    public NotFoundTeacherException(String message) {
        super(message);
        errorCode = ErrorCode.TEACHER_NOT_FOUND;
    }
}
