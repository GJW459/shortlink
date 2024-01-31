package com.wei.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录返回参数响应
 * @author wei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {

    /**
     * 登录token
     */
    private String token;

}
