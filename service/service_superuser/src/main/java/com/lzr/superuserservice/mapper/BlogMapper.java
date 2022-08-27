package com.lzr.superuserservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.lzr.superuserservice.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzr.superuserservice.entity.vo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    IPage<BlogQuery> findByPage(IPage<BlogQuery> page, @Param("blogQuery") BlogQuery blogQuery);
}
