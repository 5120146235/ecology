package com.zlxy.boot.service.impl;

import com.zlxy.boot.dao.UserMapper;
import com.zlxy.boot.entity.User;
import com.zlxy.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate <String,Object> redisTemplate;

    @Override
    public User getuserInfo(int id) {
        BoundValueOperations <String,Object> usersOpt = redisTemplate.boundValueOps("users");
        User user = (User) usersOpt.get();
        if(user == null){
            user = userMapper.getUserInfo(id);
            usersOpt.set(user);
            System.out.println(">>>>>>>>>>>>>>>数据库>>>>>>>>>>>>>>");
        }else{
            System.out.println(">>>>>>>>>>>>>>>缓存>>>>>>>>>>>>>>");
        }
        return user;
    }
}
