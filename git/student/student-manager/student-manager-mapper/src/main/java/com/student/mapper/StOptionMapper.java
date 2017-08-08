package com.student.mapper;

import com.student.pojo.StOption;
import com.student.pojo.StOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StOptionMapper {
    int countByExample(StOptionExample example);

    int deleteByExample(StOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StOption record);

    int insertSelective(StOption record);

    List<StOption> selectByExampleWithBLOBs(StOptionExample example);

    List<StOption> selectByExample(StOptionExample example);

    StOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StOption record, @Param("example") StOptionExample example);

    int updateByExampleWithBLOBs(@Param("record") StOption record, @Param("example") StOptionExample example);

    int updateByExample(@Param("record") StOption record, @Param("example") StOptionExample example);

    int updateByPrimaryKeySelective(StOption record);

    int updateByPrimaryKeyWithBLOBs(StOption record);

    int updateByPrimaryKey(StOption record);
}