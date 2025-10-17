package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qingshun.meng
 * @ClassName UserServiceImpl
 * @description: TODO
 * @date 2025年10月02日
 * @version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //@Autowired
    //private UserMapper userMapper;
    //
    //@Override
    //public  List<User> list() {
    //    List<User> users = userMapper.selectAll();
    //    return users;
    //}
    //
    //@Override
    //public String insertForeach(List<User> userList) {
    //    for (User user : userList) {
    //        user.setCreateTime(new Date());
    //        user.setUpdateTime(new Date());
    //        user.setStatus(0);
    //    }
    //    //批量插入数据
    //    userMapper.insertForeach(userList);
    //    return "保存成功";
    //}
}
