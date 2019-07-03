package com.qinpiyi.common.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.PageInfo;

public interface QueryService<T> {

	int countByExample(Object example);

	List<T> selectByExample(Object example);

	T selectOne(T record);

	List<T> select(T record);

	List<T> selectAll();

	T selectOneByExample(Object example);

	PageInfo<T> selectByExample(Object example, RowBounds rowBounds);

	PageInfo<T> selectByRowBounds(T record, RowBounds rowBounds);

	T selectByPrimaryKey(Object id);
}
