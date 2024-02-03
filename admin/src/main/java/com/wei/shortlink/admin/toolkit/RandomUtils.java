package com.wei.shortlink.admin.toolkit;

import java.security.SecureRandom;

/**
 * 随机生成字符串工具类
 * @author wei
 */
public final class RandomUtils {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandom(){
        return generateRandom(6);
    }

    public static String generateRandom(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
