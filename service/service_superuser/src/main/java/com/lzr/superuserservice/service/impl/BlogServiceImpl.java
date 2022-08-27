package com.lzr.superuserservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.superuserservice.entity.Blog;
import com.lzr.superuserservice.entity.vo.BlogQuery;
import com.lzr.superuserservice.mapper.BlogMapper;
import com.lzr.superuserservice.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Override
    public IPage<BlogQuery> findByPage(IPage<BlogQuery> pageBlog, BlogQuery blogQuery) {
        IPage<BlogQuery> blogQueryIPage = blogMapper.findByPage(pageBlog, blogQuery);
        return blogQueryIPage;
    }
}
