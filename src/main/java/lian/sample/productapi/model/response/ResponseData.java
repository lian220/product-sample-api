package lian.sample.productapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseData {
    private String resultCode;
    private String message;
    private Object data;

    public ResponseData(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
