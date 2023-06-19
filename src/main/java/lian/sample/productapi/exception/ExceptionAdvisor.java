package lian.sample.productapi.exception;

import lian.sample.productapi.model.response.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData> processValidationError(MethodArgumentNotValidException exception) {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .resultCode("9999")
                        .message(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseData> processValidationError(HttpMessageNotReadableException exception) {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .resultCode("9998")
                        .message(exception.getCause().getLocalizedMessage())
                        .build()
        );
    }
}
