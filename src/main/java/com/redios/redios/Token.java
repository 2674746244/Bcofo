package com.redios.redios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
//Token组成 前缀（token）-设备（pc）-特定的用户加密信息32位-时间（年月日时分秒格式）-防止重复的随机6位码
//Token存储在redis中
public class Token {
    public String createToken(User user){
        StringBuilder builder=new StringBuilder();
        builder.append("token-");
        builder.append("PC-");
        builder.append("userinfo-");
        builder.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        builder.append(UUID.randomUUID().toString().substring(0,6));
        return builder.toString();
    }
}
