package com.lzr.cliservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzr.cliservice.entity.BbsTopic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzr.cliservice.entity.vo.TopicListQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
public interface BbsTopicService extends IService<BbsTopic> {
    IPage<TopicListQuery> findByPage(IPage<TopicListQuery> pageTopic, TopicListQuery topicListQuery);

    void addViewCount(int topicId);

    List<TopicListQuery> listAll(String plateName);
}
