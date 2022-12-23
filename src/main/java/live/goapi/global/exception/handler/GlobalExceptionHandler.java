package live.goapi.global.exception.handler;

import live.goapi.domain.api_key.exception.ExistsRandomKeyException;
import live.goapi.domain.api_key.exception.MisMatchRandomKeyException;
import live.goapi.domain.auth.exception.ExistsEmailException;
import live.goapi.domain.auth.exception.RefreshTokenNotFoundException;
import live.goapi.domain.club.exception.ClubNotFoundException;
import live.goapi.domain.email.exception.AuthCodeExpiredException;
import live.goapi.domain.email.exception.ManyRequestEmailAuthException;
import live.goapi.domain.email.exception.MisMatchAuthCodeException;
import live.goapi.domain.student.exception.NotFoundStudentException;
import live.goapi.domain.member.exception.MemberNotFoundException;
import live.goapi.domain.auth.exception.PasswordMismatchException;
import live.goapi.domain.survey.exception.AlreadyWriteSurveyException;
import live.goapi.domain.survey.exception.NotWriteSurveyException;
import live.goapi.global.exception.ErrorResponse;
import live.goapi.domain.teacher.exception.NotFoundTeacherException;
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

    @ExceptionHandler(AuthCodeExpiredException.class)
    public ResponseEntity<ErrorResponse> handleAuthCodeExpiredException(HttpServletRequest request , AuthCodeExpiredException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ManyRequestEmailAuthException.class)
    public ResponseEntity<ErrorResponse> handleManyRequestEmailAuthException(HttpServletRequest request , ManyRequestEmailAuthException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MisMatchAuthCodeException.class)
    public ResponseEntity<ErrorResponse> handleMisMatchAuthCodeException(HttpServletRequest request , MisMatchAuthCodeException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ClubNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClubNotFoundException(HttpServletRequest request , ClubNotFoundException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRefreshTokenNotFoundException(HttpServletRequest request , RefreshTokenNotFoundException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ExistsEmailException.class)
    public ResponseEntity<ErrorResponse> handleExistsEmailException(HttpServletRequest request , ExistsEmailException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ExistsRandomKeyException.class)
    public ResponseEntity<ErrorResponse> handleExistsRandomKeyException(HttpServletRequest request , ExistsRandomKeyException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MisMatchRandomKeyException.class)
    public ResponseEntity<ErrorResponse> handleMisMatchRandomKeyException(HttpServletRequest request , MisMatchRandomKeyException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotWriteSurveyException.class)
    public ResponseEntity<ErrorResponse> handleNotWriteSurveyException(HttpServletRequest request , NotWriteSurveyException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(AlreadyWriteSurveyException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyWriteSurveyException(HttpServletRequest request , AlreadyWriteSurveyException e) {
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
