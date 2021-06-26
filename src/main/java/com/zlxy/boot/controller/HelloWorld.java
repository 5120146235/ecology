package com.zlxy.boot.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloWorld {

    /**
     * 测试Springboot接口
     * @return
     */
    @RequestMapping("/helloworld")
    @ResponseBody
    public Map<String,Object> testController(){
        Map<String,Object> map = new HashMap<>();
        String loginid = "";
        Integer age = 0;
        Boolean isAccount = false;
        List userInfo = new ArrayList();

        map.put("loginid",loginid);
        map.put("age",age);
        map.put("isAccount",isAccount);
        map.put("userInfo",userInfo);
        map.put("username","");
        return map;
    }
}
