package com.zlxy.boot.dao;

import com.zlxy.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    User getUserInfo(int id);
}
