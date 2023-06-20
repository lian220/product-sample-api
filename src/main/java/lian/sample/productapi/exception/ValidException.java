package lian.sample.productapi.exception;

import lian.sample.productapi.model.response.ResponseData;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidException extends RuntimeException {
    private String key;
    private String value;

    public ValidException(String key, String value) {
        super(value);
        this.key = key;
        this.value = value;
    }

    public ResponseData body(){
        ValidDto validDTO = new ValidDto(key, value);
        return new ResponseData(HttpStatus.BAD_REQUEST, "badRequest", validDTO);
    }

    public HttpStatus status(){
        return HttpStatus.BAD_REQUEST;
    }
}
