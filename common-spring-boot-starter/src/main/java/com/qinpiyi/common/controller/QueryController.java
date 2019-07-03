package com.qinpiyi.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.qinpiyi.common.response.CommonResponse;
import com.qinpiyi.common.response.CommonResponseUtil;
import com.qinpiyi.common.service.QueryService;

import io.swagger.annotations.ApiOperation;

public class QueryController<T> {

	@Autowired
	protected QueryService<T> queryService;

	/**
	 * 分页查询.
	 * 
	 * @param page
	 * @param pagesize
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "返回CommonResponse")
	@RequestMapping(value = "/queryByPage", method = { RequestMethod.GET })
	public CommonResponse queryByPage(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, T entity, HttpServletRequest request) {

		if (pageNum < 1) {
			pageNum = 1;
		}
		int offset = (pageNum - 1) * pageSize;
		int limit = pageSize;
		PageInfo<T> p = queryService.selectByRowBounds(entity, new RowBounds(offset, limit));
		return CommonResponseUtil.success(p);
	}

	/**
	 * 分页查询.
	 * 
	 * @param page
	 * @param pagesize
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "返回PageInfo<T>")
	@RequestMapping(value = "/queryPage", method = { RequestMethod.GET })
	public PageInfo<T> queryPage(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, T entity, HttpServletRequest request) {

		if (pageNum < 1) {
			pageNum = 1;
		}
		int offset = (pageNum - 1) * pageSize;
		int limit = pageSize;
		PageInfo<T> p = queryService.selectByRowBounds(entity, new RowBounds(offset, limit));
		return p;
	}

	/**
	 * 根据ID查询对象
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "根据ID查询对象")
	@RequestMapping(value = "/queryById", method = { RequestMethod.GET })
	public CommonResponse queryById(Object id, HttpServletRequest request) {
		T t = queryService.selectByPrimaryKey(id);
		return CommonResponseUtil.success(t);
	}

	/**
	 * 查询列表.
	 * 
	 * @param dto
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "查询列表", notes = "不分页")
	@RequestMapping(value = "/queryList", method = { RequestMethod.POST, RequestMethod.GET })
	public CommonResponse query(T entity, HttpServletRequest request) throws Exception {
		List<T> list = queryService.select(entity);
		return CommonResponseUtil.success(list);
	}

}
