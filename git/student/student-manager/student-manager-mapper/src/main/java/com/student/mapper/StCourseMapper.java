package com.student.mapper;

import com.student.pojo.StCourse;
import com.student.pojo.StCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StCourseMapper {
    int countByExample(StCourseExample example);

    int deleteByExample(StCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StCourse record);

    int insertSelective(StCourse record);

    List<StCourse> selectByExample(StCourseExample example);

    StCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StCourse record, @Param("example") StCourseExample example);

    int updateByExample(@Param("record") StCourse record, @Param("example") StCourseExample example);

    int updateByPrimaryKeySelective(StCourse record);

    int updateByPrimaryKey(StCourse record);
}