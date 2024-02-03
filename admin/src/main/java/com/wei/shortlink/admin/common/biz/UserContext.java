package com.wei.shortlink.admin.common.biz;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.Optional;

/**
 * 用户信息上下文
 *
 * @author wei
 */
public class UserContext {

    /**
     * <a href="https://github.com/alibaba/transmittable-thread-local" />
     */
    private static final ThreadLocal<UserInfoDTO> USER_THREAD_LOCAL = new TransmittableThreadLocal<>();

    /**
     * 设置用户上下文
     * @param userInfoDTO 用户详情信息
     */
    public static void setUser(UserInfoDTO userInfoDTO) {
        USER_THREAD_LOCAL.set(userInfoDTO);
    }

    /**
     * 获取用户id
     * @return 用户id
     */
    public static String getUserId() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getUserId).orElse(null);
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public static String getUsername() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getUsername).orElse(null);
    }

    /**
     * 获取用户真实名称
     * @return 用户真实名称
     */
    public static String getRealName() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getRealName).orElse(null);
    }

    /**
     * 移除用户信息
     */
    public static void removeUser(){
        USER_THREAD_LOCAL.remove();
    }
}
