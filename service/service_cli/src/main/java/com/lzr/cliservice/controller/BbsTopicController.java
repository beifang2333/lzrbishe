package com.lzr.cliservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.cliservice.entity.BbsTopic;
import com.lzr.cliservice.entity.vo.TopicListQuery;
import com.lzr.cliservice.service.BbsTopicService;
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
@RequestMapping("/cliservice/bbstopic")
@CrossOrigin
public class BbsTopicController {
    @Autowired
    private BbsTopicService bbsTopicService;

    @PostMapping("getTopicListPage/{current}/{limit}")
    public R getTopicListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) TopicListQuery topicListQuery){
        Page<TopicListQuery> pageTopic = new Page<>(current,limit);
        bbsTopicService.findByPage(pageTopic,topicListQuery);
        List<TopicListQuery> list = pageTopic.getRecords();
        long total = pageTopic.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @GetMapping("getTopicListPageByPlateName/{plateName}")
    public R getTopicListPageByPlateName(@PathVariable String plateName){
        List<TopicListQuery> list =bbsTopicService.listAll(plateName);
        return R.ok().data("list",list);
    }

    @GetMapping("getTopicById/{topicId}")
    public R getTopicById(@PathVariable int topicId){
        return R.ok().data("topic",bbsTopicService.getById(topicId));
    }

    @GetMapping("addViewCount/{topicId}")
    public R addViewCount(@PathVariable int topicId){
        bbsTopicService.addViewCount(topicId);
        return R.ok();
    }
    @PostMapping("addTopic")
    public R addTopic(@RequestBody BbsTopic bbsTopic){
        bbsTopicService.save(bbsTopic);
        return R.ok();
    }
}

