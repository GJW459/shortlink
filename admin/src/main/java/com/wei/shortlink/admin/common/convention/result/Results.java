package com.wei.shortlink.admin.common.convention.result;

import com.wei.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.wei.shortlink.admin.common.convention.exception.AbstractException;

import java.util.Optional;

/**
 * 全局返回对象构造器
 *
 * @author wei
 */
public final class Results {

    /**
     * 构造成功响应
     */
    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带返回数据的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构造服务端失败响应
     */
    public static Result<Void> failure() {
        return new Result<Void>()
                .setCode(BaseErrorCode.SERVICE_ERROR.code());
    }

    /**
     * 根据{@link AbstractException} 构造失败响应
     */
    public static Result<Void> failure(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode())
                .orElse(BaseErrorCode.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
                .orElse(BaseErrorCode.SERVICE_ERROR.message());
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }

    /**
     * 通过errorCode、errorMessage 构造失败响应
     */
    public static Result<Void> failure(String errorCode, String errorMessage) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}
