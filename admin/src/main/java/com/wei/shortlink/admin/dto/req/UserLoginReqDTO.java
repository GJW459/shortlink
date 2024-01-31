package com.wei.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 用户注册入参
 * @author wei
 */
@Data
public class UserLoginReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
