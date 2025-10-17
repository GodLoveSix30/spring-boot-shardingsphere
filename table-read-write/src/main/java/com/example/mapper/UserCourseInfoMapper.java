package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.UserCourseInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auth roykingw
 */
public interface UserCourseInfoMapper extends BaseMapper<UserCourseInfo> {
    @Select("select uci.* from user_course_info uci ,user u where uci.userid = u.userid")
    List<UserCourseInfo> queryUserCourse();
}
