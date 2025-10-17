package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qingshun.meng
 * @ClassName UserMapper
 * @description: TODO
 * @date 2025年10月02日
 * @version: 1.0
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {
    /**
     * 批量插入
     *
     * @param list 插入集合
     * @return 插入数量
     */
    //int insertForeach(List<User> list);

    /**
     * 获取所有用户
     */
    //List<User> selectAll();

    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    //int insert(User record);
}
