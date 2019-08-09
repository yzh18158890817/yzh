package com.yzh.common.mapper;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author yzh
 * @date 2019/8/8
 */
@RegisterMapper
public interface BasseMapper<T> extends Mapper<T>, IdListMapper<T, Long>, InsertListMapper<T> {
}
