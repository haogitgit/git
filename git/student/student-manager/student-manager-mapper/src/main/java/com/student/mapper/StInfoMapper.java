package com.student.mapper;

import com.student.pojo.StInfo;
import com.student.pojo.StInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StInfoMapper {
    int countByExample(StInfoExample example);

    int deleteByExample(StInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StInfo record);

    int insertSelective(StInfo record);

    List<StInfo> selectByExample(StInfoExample example);

    StInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StInfo record, @Param("example") StInfoExample example);

    int updateByExample(@Param("record") StInfo record, @Param("example") StInfoExample example);

    int updateByPrimaryKeySelective(StInfo record);

    int updateByPrimaryKey(StInfo record);
}