package com.wei.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.shortlink.admin.dao.entity.UserDO;
import com.wei.shortlink.admin.dto.req.UserLoginReqDTO;
import com.wei.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.wei.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.wei.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.wei.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 * @author wei
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return
     */
    Boolean hasUsername(String username);

    /**
     * 用户注册
     * @param requestParam 用户注册入参
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 用户修改
     * @param requestParam 用户修改信息入参
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     * @param requestParam 用户登录入参
     * @return
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户是否登录
     * @param username 用户名
     * @param token token
     * @return
     */
    Boolean checkLogin(String username, String token);

    /**
     * 用户退出登录
     * @param username 用户名
     * @param token token
     */
    void logout(String username, String token);
}
