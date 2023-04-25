package com.lzr.cliservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.cliservice.entity.BbsPost;
import com.lzr.cliservice.entity.vo.PostList;
import com.lzr.cliservice.entity.vo.TopicListQuery;
import com.lzr.cliservice.service.BbsPostService;
import com.lzr.cliservice.service.BbsUserService;
import com.lzr.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/cliservice/bbspost")
@CrossOrigin
public class BbsPostController {
    @Autowired
    private BbsPostService bbsPostService;

    @GetMapping("getPostListByTopicId/{topicId}")
    public R getPostListByTopicId(@PathVariable int topicId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("topic_id",topicId);
        return R.ok().data("postList",bbsPostService.list(wrapper));
    }
    //根据topicId查询评论列表
    @GetMapping("getPostList/{topicId}")
    public R getPostList(@PathVariable int topicId){
        List<PostList> list = bbsPostService.findPostList(topicId);
        return R.ok().data("postList",list);
    }
    //发布评论
    @PostMapping("addPost")
    public R addPost(@RequestBody BbsPost bbsPost){
        boolean save = bbsPostService.save(bbsPost);
        return save ? R.ok():R.error();
    }
}

