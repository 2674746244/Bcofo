package com.redios.redios;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String ,Object> redisTemplate;
    public boolean set(String key,String val){
        try {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            ValueOperations<String,Object>vo=redisTemplate.opsForValue();
            vo.set(key,val);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }


    public boolean  set(String key,String val,long time ){
        try {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            ValueOperations<String ,Object>vo=redisTemplate.opsForValue();
            vo.set(key,val);
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Object exist(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String ,Object> vo=redisTemplate.opsForValue();

        return vo.get(key);
}




}
