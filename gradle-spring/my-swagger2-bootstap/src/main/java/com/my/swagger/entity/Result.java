package com.my.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.jws.HandlerChain;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public <T> Result success(T data) {
        Result<T> success = new Result<T>().setCode("200").setMessage("success").setData(data);
        return success;
    }

    public <T> Result fail(String message) {
        Result<T> fail = new Result<T>().setCode("409").setMessage(message);
        return fail;
    }
}
