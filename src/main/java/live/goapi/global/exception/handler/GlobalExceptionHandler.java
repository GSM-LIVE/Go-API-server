package live.goapi.global.exception.handler;

import live.goapi.domain.gsmapi.student.exception.NotFoundStudentException;
import live.goapi.domain.member.exception.MemberNotFoundException;
import live.goapi.domain.member.exception.PasswordMismatchException;
import live.goapi.global.exception.ErrorResponse;
import live.goapi.domain.gsmapi.teacher.exception.NotFoundTeacherException;
import live.goapi.global.security.exception.TokenExpirationException;
import live.goapi.global.security.exception.TokenNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundTeacherException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundTeacherException(HttpServletRequest request , NotFoundTeacherException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundStudentException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundStudentException(HttpServletRequest request , NotFoundStudentException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorResponse> handleTokenExpirationException(HttpServletRequest request , TokenExpirationException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<ErrorResponse> handleTokenNotValidException(HttpServletRequest request , TokenNotValidException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMemberNotFoundException(HttpServletRequest request , MemberNotFoundException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ErrorResponse> handlePasswordMismatchException(HttpServletRequest request , PasswordMismatchException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }


    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}
