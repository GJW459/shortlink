package com.wei.shortlink.admin.common.biz;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Objects;

import static com.wei.shortlink.admin.common.constant.RedisCacheConstant.USER_LOGIN_KEY;

/**
 * @author wei
 */
@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {

    private final StringRedisTemplate stringRedisTemplate;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        if (!Objects.equals(requestURI, "/api/short-link/admin/v1/user/login")) {
            String token = httpServletRequest.getHeader("token");
            String username = httpServletRequest.getHeader("username");
            Object userInfoJsonStr = stringRedisTemplate.opsForHash().get(USER_LOGIN_KEY + username, token);
            if (userInfoJsonStr != null) {
                UserInfoDTO userInfoDTO = JSON.parseObject(userInfoJsonStr.toString(), UserInfoDTO.class);
                UserContext.setUser(userInfoDTO);
            }
        }
        try {
            chain.doFilter(request, response);
        }  finally {
            UserContext.removeUser();
        }
    }
}
