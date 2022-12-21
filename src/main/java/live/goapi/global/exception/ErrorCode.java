package live.goapi.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    TEACHER_NOT_FOUND("선생님을 찾을 수 없습니다", 404),
    STUDENT_NOT_FOUND("학생을 찾을 수 없습니다", 404),
    MANY_REQUEST_EMAIL_AUTH("15분에 최대 3번의 이메일 요청만 가능합니다." , 429),
    EXPIRE_EMAIL_CODE("이메일 인증번호 시간이 만료되었습니다.", 401),
    MEMBER_NOT_FOUND("존재하지 않는 회원입니다.", 404),
    MISMATCH_AUTH_CODE("인증번호가 일치하지 않습니다." , 400),
    NOT_VERIFY_EMAIL("검증되지 않은 이메일입니다." , 401),
    MISMATCH_MEMBER_PASSWORD("비밀번호가 일치하지 않습니다.", 400),
    ALREADY_EXIST_EMAIL("이미 존재하는 이메일입니다." , 400),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),
    NOTICE_NOT_FOUND("공지사항이 존재하지 않습니다.", 404),
    CLUB_NOT_FOUND("존재하지 않는 전공동아리 입니다.", 404),
    REFRESH_TOKEN_NOT_FOUND("존재하지 않는 리프레시 토큰입니다.", 404),
    MISMATCH_API_KEY("인증키가 일치하지 않습니다.", 400),
    ALREADY_EXIST_KEY("이미 랜덤키를 발급받았습니다." , 400);

    private final String message;
    private final int status;
}
