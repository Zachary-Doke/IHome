package com.ihome.pojo;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseMessage<T> {
    private int code;
    private String message;
    private T data;

    public ResponseMessage(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>(HttpStatus.OK.value(), "success", data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
