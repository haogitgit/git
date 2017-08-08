package com.student.mapper;

import com.student.pojo.StUser;
import com.student.pojo.StUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StUserMapper {
    int countByExample(StUserExample example);

    int deleteByExample(StUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StUser record);

    int insertSelective(StUser record);

    List<StUser> selectByExample(StUserExample example);

    StUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StUser record, @Param("example") StUserExample example);

    int updateByExample(@Param("record") StUser record, @Param("example") StUserExample example);

    int updateByPrimaryKeySelective(StUser record);

    int updateByPrimaryKey(StUser record);
}