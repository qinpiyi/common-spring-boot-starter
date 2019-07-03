package com.qinpiyi.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseService<T> extends QueryService<T> {

	int insert(T record);

	int insertSelective(T record);

	int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

	int updateByExample(@Param("record") T record, @Param("example") Object example);

	int updateByPrimaryKeySelective(T record);// 选择性更新：只更新不为空的字段

	int updateByPrimaryKey(T record);

	List<T> batchUpdate(List<T> objs);

	int deleteByExample(Object example);

	int delete(T record);

	int deleteByPrimaryKey(Object id);

	List<T> batchDelete(List<T> objs);

	int batchDeleteByPrimaryKey(List<Object> ids);

}
