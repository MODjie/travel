package com.java.travel.mapper;

import com.java.travel.entity.Register;

public interface RegisterMapper {
    /**
     * 通过注册编号删除注册用户
     * @param REGISTERID
     * @return
     */
	int deleteByPrimaryKey(Short REGISTERID);

    /**
     * 添加注册用户
     * @param record
     * @return
     */
    int insert(Register record);
    
    /**
     * 插入一条数据,只插入不为null的字段,不会影响有默认值的字段
     * 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
     * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
     * @param record
     * @return
     */
    int insertSelective(Register record);

    Register selectByPrimaryKey(Short REGISTERID);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}