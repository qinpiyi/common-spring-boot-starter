package com.qinpiyi.common.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.qinpiyi.common.mapper.MyBatisMapper;

public class QueryServiceImpl<T> {

	@Autowired
	protected MyBatisMapper<T> mapper;

	public int countByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	public T selectOne(T record) {

		return mapper.selectOne(record);
	}

	public List<T> select(T record) {
		return mapper.select(record);
	}

	public List<T> selectAll() {
		return mapper.selectAll();
	}

	public T selectOneByExample(Object example) {
		return mapper.selectOneByExample(example);
	}

	public PageInfo<T> selectByExample(Object example, RowBounds rowBounds) {
		List<T> list = mapper.selectByExampleAndRowBounds(example, rowBounds);
		return new PageInfo<T>(list);
	}

	public PageInfo<T> selectByRowBounds(T record, RowBounds rowBounds) {
		List<T> list = mapper.selectByRowBounds(record, rowBounds);
		return new PageInfo<T>(list);
	}

	public T selectByPrimaryKey(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

}
