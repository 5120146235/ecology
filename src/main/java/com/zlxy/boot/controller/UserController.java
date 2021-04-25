package com.zlxy.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlxy.boot.entity.User;
import com.zlxy.boot.service.IUserService;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newCachedThreadPool;

@RestController
@RequestMapping("/user")
@Api(description = "用户操作接口",tags = {"所有用户相关接口"})
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     *3、占位符映射
     * 语法：@RequestMapping("/getUserInfo/{id}")
     * 请求路径：http://localhost:8080/getUserInfo/1
     * @param id 人员id
     * @return
     */

    @RequestMapping(value = { "/getUserInfo/{id}" }, method = RequestMethod.GET)
    @ApiOperation(value="获取人员信息接口",response = String.class)
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id", value = "人员id", required = true)
            })
    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "人员信息",  response=String.class),
            @ApiResponse(code = -1, message = "500(系统错误)",response = String.class)
    })
    public Map<String,String> getUserInfo(@PathVariable("id")Integer id){
        Map<String,String>retmap = new HashMap<>();
        try{
            ExecutorService service = Executors.newFixedThreadPool(1000);
            User user =userService.getuserInfo(id);
            Runnable runnable = ()-> {
                userService.getuserInfo(id);
            };

            for(int i = 0;i<20000;i++){
                service.execute(runnable);
            }

            retmap.put("status","1");
            retmap.put("userid",user.getId().toString());
            retmap.put("loginid",user.getLoginid().toString());
            retmap.put("password",user.getPassword().toString());
            retmap.put("pinyinlastname",user.getPinYinLastName().toString());
        }catch (Exception e){
            retmap.put("status","-1");
            System.out.println(e);
            e.printStackTrace();
        }
        return retmap;
    }

}
