package com.lzr.superuserservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.superuserservice.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzr.superuserservice.entity.vo.BlogQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
public interface BlogService extends IService<Blog> {
    IPage<BlogQuery> findByPage(IPage<BlogQuery> pageBlog,BlogQuery blogQuery);
}
