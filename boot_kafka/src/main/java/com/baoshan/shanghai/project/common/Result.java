package com.baoshan.shanghai.project.common;

import lombok.Data;

@Data
public class Result <T>{
    private static final Integer SUCCESS = 0;
    private static final Integer FAIL = 500;
    private static final Integer WARN = 1;

    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result warn(Object data){
        return new Result(WARN,data);
    }
    public static Result error(Object data){
        return new Result(FAIL,data);
    }
    public static Result ok(String msg, Object data) {
        return new Result(SUCCESS, msg, data);
    }

    /**
     * 带数据
     * @param data
     * @return
     */
    public static Result ok(Object data) {
        return new Result(SUCCESS,data);
    }

    /**
     * 成功返回通用数据
     * @return
     */
    public static Result ok() {
        return new Result(SUCCESS, "操作成功");
    }

    public static Result error() {
        return Result.error("");
    }
}
