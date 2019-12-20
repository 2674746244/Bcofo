package com.redios.redios;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisContrll {
    @Resource
    private RedisUtils redisUtils;
    @RequestMapping("/")
    public String init(Model model)
    {

        return "index";
    }
    @RequestMapping("/redis")
    public String save(String key,String val){
        System.out.println(redisUtils.exist(key));
        return "aaa" ;
    }

}
