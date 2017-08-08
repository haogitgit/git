package com.student.mapper;

import com.student.pojo.StGrade;
import com.student.pojo.StGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StGradeMapper {
    int countByExample(StGradeExample example);

    int deleteByExample(StGradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StGrade record);

    int insertSelective(StGrade record);

    List<StGrade> selectByExample(StGradeExample example);

    StGrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StGrade record, @Param("example") StGradeExample example);

    int updateByExample(@Param("record") StGrade record, @Param("example") StGradeExample example);

    int updateByPrimaryKeySelective(StGrade record);

    int updateByPrimaryKey(StGrade record);
}