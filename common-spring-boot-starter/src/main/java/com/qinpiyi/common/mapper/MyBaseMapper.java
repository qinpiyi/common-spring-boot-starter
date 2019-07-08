package com.qinpiyi.common.mapper;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface MyBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
