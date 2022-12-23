package live.goapi.domain.survey.exception;

import live.goapi.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AlreadyWriteSurveyException extends RuntimeException {

    private final ErrorCode errorCode;

    public AlreadyWriteSurveyException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_WRITE_SURVEY;
    }
}
