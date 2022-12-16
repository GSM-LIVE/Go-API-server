package live.goapi.global.exception.handler;

import live.goapi.domain.gsmapi.student.exception.NotFoundStudentException;
import live.goapi.global.exception.ErrorResponse;
import live.goapi.domain.gsmapi.teacher.exception.NotFoundTeacherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundTeacherException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundTeacherException(NotFoundTeacherException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundStudentException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundStudentException(NotFoundStudentException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
}
