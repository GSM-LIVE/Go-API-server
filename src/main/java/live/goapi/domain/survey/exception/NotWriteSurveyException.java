package live.goapi.domain.survey.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotWriteSurveyException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotWriteSurveyException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_WRITE_SURVEY;
    }
}
