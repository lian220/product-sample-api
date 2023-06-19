package lian.sample.productapi.model.response;

import lombok.Getter;

@Getter
public class ResponseData {
    private boolean success;
    private String message;
    private Object data;

    public ResponseData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
