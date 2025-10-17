package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author qingshun.meng
 * @ClassName UserController
 * @description: TODO
 * @date 2025年10月02日
 * @version: 1.0
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 模拟插入数据
     */
    List<User> userList = Lists.newArrayList();
    /**
     * 初始化插入数据
     */
    //@PostConstruct
    //private void getData() {
    //    userList.add(new User(100L,"小小", "女", 3));
    //    userList.add(new User(101L,"爸爸", "男", 30));
    //    userList.add(new User(102L,"妈妈", "女", 28));
    //    userList.add(new User(103L,"爷爷", "男", 64));
    //    userList.add(new User(104L,"奶奶", "女", 62));
    //}
    /**
     * @Description: 批量保存用户
     */
    @PostMapping("save-user")
    public Object saveUser() {
        int random = (int) (Math.random() * 1000 + 1);
        String randomUsername = "王二" + random;
        User user = new User();
        user.setName(randomUsername);
        int insert = userMapper.insert(user);
        if (insert > 0) {
            log.info("数据插入成功:{}", JSON.toJSONString(user));
        }
        //数据查询
        List<User> queryUsername1 = userMapper.selectList(new QueryWrapper<User>().eq("name", randomUsername));
        log.info("数据查询1:{}", JSON.toJSONString(queryUsername1));
        List<User> queryUsername2 = userMapper.selectList(new QueryWrapper<User>().eq("name", randomUsername));
        log.info("数据查询2:{}", JSON.toJSONString(queryUsername2));

        return queryUsername1;
    }
    /**
     * @Description: 获取用户列表
     */
    @GetMapping("list-user")
    public Object listUser() {

        //return userMapper.list();
        return null;
    }


}
