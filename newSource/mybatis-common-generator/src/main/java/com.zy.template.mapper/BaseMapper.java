package com.zy.template.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的BaseMapper
 *
 * @author zhang
 * @since 2021/2/19
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
