package com.wei.shortlink.admin.common.convention.exception;

import com.wei.shortlink.admin.common.convention.errorcode.IErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 项目中抽象出三类异常，客户端异常、服务端异常和远程服务调用异常
 *
 * @author wei
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 */
@Getter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable cause, IErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
