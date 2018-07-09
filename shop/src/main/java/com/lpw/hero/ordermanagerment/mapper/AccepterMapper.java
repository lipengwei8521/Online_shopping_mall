package com.lpw.hero.ordermanagerment.mapper;

import com.lpw.hero.ordermanagerment.bean.Accepter;
import com.lpw.hero.ordermanagerment.bean.AccepterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccepterMapper {
    int countByExample(AccepterExample example);

    int deleteByExample(AccepterExample example);

    int deleteByPrimaryKey(Integer accepterId);

    int insert(Accepter record);

    int insertSelective(Accepter record);

    List<Accepter> selectByExample(AccepterExample example);

    Accepter selectByPrimaryKey(Integer accepterId);

    int updateByExampleSelective(@Param("record") Accepter record, @Param("example") AccepterExample example);

    int updateByExample(@Param("record") Accepter record, @Param("example") AccepterExample example);

    int updateByPrimaryKeySelective(Accepter record);

    int updateByPrimaryKey(Accepter record);
}