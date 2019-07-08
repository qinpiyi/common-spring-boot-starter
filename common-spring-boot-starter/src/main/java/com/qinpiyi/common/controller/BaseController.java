package com.qinpiyi.common.controller;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qinpiyi.common.response.CommonResponse;
import com.qinpiyi.common.response.CommonResponseUtil;
import com.qinpiyi.common.service.BaseService;

import io.swagger.annotations.ApiOperation;

public class BaseController<T> extends QueryController<T> {

	protected BaseService<T> baseService;

	/**
	 * 批量更新对象
	 */
	@ApiOperation(value = "批量更新对象")
	@PostMapping(value = "/batchUpdate")
	public CommonResponse batchUpdate(HttpServletRequest request, @RequestBody List<T> objs) {
		baseService.batchUpdate(objs);
		return CommonResponseUtil.success(objs,"更新成功");
	}

	/**
	 * 批量删除
	 */
	@ApiOperation(value = "批量删除", notes = "根据对象集合批量删除")
	@PostMapping(value = "/remove")
	public CommonResponse delete(HttpServletRequest request, @RequestBody List<T> dto) {
		baseService.batchDelete(dto);
		return CommonResponseUtil.success(dto,"删除成功");
	}

	/**
	 * 批量删除
	 */
	@ApiOperation(value = "批量删除", notes = "根据ID集合批量删除")
	@PostMapping(value = "/removeByIds")
	public CommonResponse deleteByIds(HttpServletRequest request, @RequestBody List<Long> ids) {
		for (Long id : ids) {
			baseService.deleteByPrimaryKey(id);
		}
		return CommonResponseUtil.success(ids,"删除成功");
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "删除")
	@PostMapping(value = "/removeById")
	public CommonResponse deleteById(HttpServletRequest request, Long id) {
		baseService.deleteByPrimaryKey(id);
		return CommonResponseUtil.success(id,"删除成功");
	}

	/**
	 * 保存或更新.
	 */
	@ApiOperation(value = "保存或更新")
	@PostMapping(value = "/saveOrUpdateOne")
	public CommonResponse saveOrUpdateOne(@RequestBody T entity) {

		return saveOrUpdate(entity);
	}

	/**
	 * 保存或更新
	 */
	@ApiOperation(value = "保存或更新")
	@PostMapping(value = "/saveOrUpdate")
	public CommonResponse saveOrUpdate(T entity) {
		try {
			Field fieldnum = entity.getClass().getDeclaredField("id");
			fieldnum.setAccessible(true);
			Object id = fieldnum.get(entity);
			if (id == null || "0".equals(id.toString())) {
				baseService.insertSelective(entity);
			} else {
				baseService.updateByPrimaryKeySelective(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonResponseUtil.exception(e.getMessage());
		}
		return CommonResponseUtil.success(entity);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "保存")
	@PostMapping(value = "/save")
	public CommonResponse save(T entity) {
		try {
			Field fieldnum = entity.getClass().getDeclaredField("id");
			fieldnum.setAccessible(true);
			Object id = fieldnum.get(entity);
			baseService.insertSelective(entity);
		} catch (Exception e) {
			e.printStackTrace();
			CommonResponseUtil.exception(e.getMessage());
		}
		return CommonResponseUtil.success(entity);
	}

	/**
	 * 更新
	 */
	@ApiOperation(value = "更新")
	@PostMapping(value = "/update")
	public CommonResponse update(T entity) {
		try {
			Field fieldnum = entity.getClass().getDeclaredField("id");
			fieldnum.setAccessible(true);
			Object id = fieldnum.get(entity);
			baseService.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			e.printStackTrace();
			CommonResponseUtil.exception(e.getMessage());
		}
		return CommonResponseUtil.success(entity);
	}

}
