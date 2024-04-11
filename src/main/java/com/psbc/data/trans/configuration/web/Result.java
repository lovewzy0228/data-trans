package com.psbc.data.trans.configuration.web;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

import static com.psbc.data.trans.common.Constants.FAIL_CODE;
import static com.psbc.data.trans.common.Constants.SUCCESS_CODE;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 16:52
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private String code;

    private String message;

    private T data;

    private Date timestamp = new Date();

    public static <T> Result<T> success(T t) {
        return new Result<T>().setCode(SUCCESS_CODE).setData(t);
    }

    public static <T> Result<T> fail(Exception e) {
        return new Result<T>().setCode(FAIL_CODE).setMessage(e.getMessage());
    }
}
