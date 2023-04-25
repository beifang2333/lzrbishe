package com.lzr.superuserservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.BbsTopic;
import com.lzr.superuserservice.entity.vo.BbsTopicQuery;
import com.lzr.superuserservice.service.BbsTopicService;
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
@RequestMapping("/superuserservice/bbstopic")
@CrossOrigin
public class BbsTopicController {
    @Autowired
    private BbsTopicService bbsTopicService;

    @PostMapping("getTopicListPage/{current}/{limit}")
    public R getTopicListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) BbsTopicQuery bbsTopicQuery){
        Page<BbsTopicQuery> pageTopic = new Page<>(current,limit);
        bbsTopicService.findByPage(pageTopic,bbsTopicQuery);
        List<BbsTopicQuery> list = pageTopic.getRecords();
        long total = pageTopic.getTotal();
        return R.ok().data("list",list).data("total",total);
    }
    @PostMapping("getTopicAuditListPage/{current}/{limit}")
    public R getTopicAuditListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) BbsTopicQuery bbsTopicQuery){
        Page<BbsTopicQuery> pageTopic = new Page<>(current,limit);
        bbsTopicService.findAuditByPage(pageTopic,bbsTopicQuery);
        List<BbsTopicQuery> list = pageTopic.getRecords();
        long total = pageTopic.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @GetMapping("getTopic/{topicId}")
    public R getTopic(@PathVariable String topicId){
        BbsTopic topic = bbsTopicService.getById(topicId);
        return R.ok().data("topic",topic);
    }

    @DeleteMapping("removeTopic/{topicId}")
    public R removeTopic(@PathVariable String topicId){
        BbsTopic byId = bbsTopicService.getById(Integer.valueOf(topicId));
        if (byId==null){
            return R.error().message("查询不到此信息");
        }
        bbsTopicService.removeById(Integer.valueOf(topicId));
        return R.ok().message("删除成功");
    }
    @PostMapping("updateBbsTopic")
    public R updateBbsTopic(@RequestBody BbsTopic Bbstopic){
        return bbsTopicService.updateById(Bbstopic) ? R.ok():R.error();
    }
}

