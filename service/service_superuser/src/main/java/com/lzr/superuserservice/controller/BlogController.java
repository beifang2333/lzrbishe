package com.lzr.superuserservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.Blog;
import com.lzr.superuserservice.entity.vo.BlogQuery;
import com.lzr.superuserservice.service.BlogService;
import com.lzr.superuserservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
@RestController
@RequestMapping("/superuserservice/blog")
@CrossOrigin
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @PostMapping("getBlogListPage/{current}/{limit}")
    public R getBlogListPage(@PathVariable long current, @PathVariable long limit,@RequestBody(required = false) BlogQuery blogQuery){
        Page<BlogQuery> pageBlog = new Page<>(current,limit);
        blogService.findByPage(pageBlog,blogQuery);
        List<BlogQuery> list = pageBlog.getRecords();
        long total = pageBlog.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @DeleteMapping("removeBlog/{bid}")
    public R removeBlog(@PathVariable String bid){
        Blog byId = blogService.getById(bid);
        if (byId==null){
            return R.error();
        }
        boolean flag = blogService.removeById(Integer.valueOf(bid));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("blog_id",byId.getBlogId());
        commentService.remove(wrapper);
        if (flag){
            return R.ok();
        }else{
            return R.error();
        }
    }
}

