package com.example.tablereadwrite;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author qingshun.meng
 * @ClassName ShardingTest
 * @description: TODO
 * @date 2025年10月14日
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class) // JUnit 4
public class ShardingTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        int random = (int) (Math.random() * 1000 + 1);
        String randomUsername = "王二" + random;
        User user = new User();
        user.setName(randomUsername);
        user.setAge(random);
        int insert = userMapper.insert(user);
        if (insert > 0) {
            System.out.println("数据插入成功:"+JSON.toJSONString(user));
        }
    }


    @Test
    public void testQuery() {
        //Actual SQL: m0 ::: SELECT  id,name,sex,age,create_time,update_time,status  FROM user1
        // WHERE  (id IN (?) AND age = ?) ::: [1977937524538585090, 711]
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", 1977937524538585090L);
        queryWrapper.eq("age", 711);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("数据查询成功:"+ JSON.toJSONString(users));
    }

    @Test
    public void testQuery1() {
        //Actual SQL: m0 ::: SELECT  id,name,sex,age,create_time,update_time,status  FROM user1
        // WHERE  (id IN (?,?) AND age = ?) UNION ALL SELECT  id,name,sex,age,create_time,update_time,status  FROM user2
        // WHERE  (id IN (?,?) AND age = ?) ::: [1977937524538585090, 1977937701626273793, 711, 1977937524538585090, 1977937701626273793, 711]

        //Actual SQL: m1 ::: SELECT  id,name,sex,age,create_time,update_time,status  FROM user1
        //WHERE  (id IN (?,?) AND age = ?) UNION ALL SELECT  id,name,sex,age,create_time,update_time,status  FROM user2
        // WHERE  (id IN (?,?) AND age = ?) ::: [1977937524538585090, 1977937701626273793, 711, 1977937524538585090, 1977937701626273793, 711]
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", 1977937524538585090L,1977937701626273793L);
        queryWrapper.eq("age", 711);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("数据查询成功:"+ JSON.toJSONString(users));
    }

    @Test
    public void testQuery2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", 1977937524538585090L,1977937701626273793L);
        queryWrapper.between("age", 1,8);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("数据查询成功:"+ JSON.toJSONString(users));
    }
}
