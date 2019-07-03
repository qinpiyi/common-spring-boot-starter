package com.qinpiyi.common.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.util.ReflectionUtils;

public class BaseServiceImpl<T> extends QueryServiceImpl<T> {

	public int insert(T record) {
		return mapper.insert(record);
	}

	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}

	public int updateByExampleSelective(T record, Object example) {
		return mapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(T record, Object example) {
		return mapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(T record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	public List<T> batchUpdate(List<T> objs) {
		for (T t : objs) {
			mapper.updateByPrimaryKey(t);
		}
		return objs;
	}

	public int deleteByExample(Object example) {
		return mapper.deleteByExample(example);
	}

	public int delete(T record) {
		return mapper.delete(record);
	}

	public int deleteByPrimaryKey(Object id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int batchDeleteByPrimaryKey(List<Object> ids) {
		int deleteCount = 0;
		for (Object id : ids) {
			mapper.deleteByPrimaryKey(id);
			deleteCount++;
		}
		return deleteCount;
	}

	public List<T> batchDelete(List<T> objs) {
		for (T t : objs) {
			mapper.deleteByPrimaryKey(getIdOfEntity(t));
		}
		return objs;
	}

	private Object getIdOfEntity(T t) {
		Class<?> entityClass = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		// 设置公共属性
		Field idField = ReflectionUtils.findField(entityClass, "id");
		idField.setAccessible(true);
		Object id = ReflectionUtils.getField(idField, t);
		return id;
	}
}
