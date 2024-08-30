package org.company.ssm.util;


import lombok.Getter;
import lombok.Setter;
import static org.company.ssm.constant.ResultConstant.*;



@Getter
@Setter
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

//    private static final  Integer OK_CODE = 200;

    private Result(){

    }

    public static <T> Result<T> ok(String msg) {
        Result<T> result = new Result<>();
        result.setCode(OK_CODE);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> ok() {
        Result<T> result = new Result<>();
        result.setCode(OK_CODE);
        result.setMsg("request_ok");
        return result;
    }

    public static <T> Result<T> err() {
        Result<T> result = new Result<>();
        result.setCode(OK_CODE);
        result.setMsg("request_err");
        return result;
    }

    public static <T> Result<T> err(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ERR_CODE);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(data);
        return result;
    }
}
