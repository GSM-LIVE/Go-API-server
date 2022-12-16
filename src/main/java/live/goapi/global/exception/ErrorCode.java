package live.goapi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    TEACHER_NOT_FOUND("선생님을 찾을 수 없습니다", 404),
    STUDENT_NOT_FOUND("학생을 찾을 수 없습니다", 404);

    private final String message;
    private final int status;
}
