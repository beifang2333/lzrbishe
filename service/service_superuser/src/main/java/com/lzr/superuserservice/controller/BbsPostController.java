package com.lzr.superuserservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.BbsPost;
import com.lzr.superuserservice.entity.vo.BbsPostQuery;
import com.lzr.superuserservice.service.BbsPostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
@RestController
@RequestMapping("/superuserservice/bbspost")
@CrossOrigin
public class BbsPostController {
    @Autowired
    private BbsPostService bbsPostService;

    @ApiOperation("条件查询评论")
    @PostMapping("getPostListPage/{current}/{limit}")
    public R getPostListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) BbsPostQuery bbsPostQuery){
        bbsPostQuery.setStatus("Normal");
        Page<BbsPostQuery> pagePost = new Page<>(current,limit);
        bbsPostService.findByPage(pagePost, bbsPostQuery);
        List<BbsPostQuery> list = pagePost.getRecords();
        long total = pagePost.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @PostMapping("getPostListAuditPage/{current}/{limit}")
    public R getPostAuditListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) BbsPostQuery bbsPostQuery){
        Page<BbsPostQuery> pagePost = new Page<>(current,limit);
        bbsPostQuery.setStatus("Draft");
        bbsPostService.findAuditByPage(pagePost, bbsPostQuery);
        List<BbsPostQuery> list = pagePost.getRecords();
        long total = pagePost.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @ApiOperation("删除评论")
    @DeleteMapping("removePost/{id}")
    public R removeUser(@PathVariable String id){
        BbsPost byId = bbsPostService.getById(id);
        if (byId==null){
            return R.error();
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("post_id",id);
        boolean flag = bbsPostService.remove(wrapper);
        if(flag){
            return R.ok();
        }
        else{
            return R.error();
        }
    }

    @ApiOperation("更新评论")
    @PostMapping("updateBbsPost")
    public R updateBbsPlate(@RequestBody BbsPost bbsPost){
        return bbsPostService.updateById(bbsPost) ? R.ok():R.error();
    }
}

