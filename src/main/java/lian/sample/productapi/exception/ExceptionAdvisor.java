package lian.sample.productapi.exception;

import lian.sample.productapi.model.response.ResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionAdvisor {

    @CustomErrorLog
    @ExceptionHandler(ValidException.class)
    public ResponseEntity<?> badRequest(ValidException e){

        return new ResponseEntity<>(e.body(), e.status());
    }

    @CustomErrorLog
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData> processValidationError(MethodArgumentNotValidException exception) {
        ResponseData apiResponseDto = new ResponseData(HttpStatus.BAD_REQUEST, "요청 값이 정확하지 않습니다.", exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CustomErrorLog
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseData> processHttpMessageReadableError(HttpMessageNotReadableException exception) {
        ResponseData apiResponseDto = new ResponseData(HttpStatus.BAD_REQUEST, "요청 값이 정확하지 않습니다.", exception.getCause().getLocalizedMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @CustomErrorLog
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unknownServerError(Exception e){

        // MDC
        MDC.put("message", "API_REQUEST_FAILED");
        MDC.put("error_code", HttpStatus.INTERNAL_SERVER_ERROR.name());
        MDC.put("error_exception", e.getClass().getName());
        MDC.put("error_message", e.getMessage());
        MDC.put("error_trace", ExceptionUtils.getStackTrace(e));

        ResponseData apiResponseDto = new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR, "unknownServerError", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
