package com.lzr.cliservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzr.cliservice.entity.BbsTopic;
import com.lzr.cliservice.entity.vo.TopicListQuery;
import com.lzr.cliservice.mapper.BbsTopicMapper;
import com.lzr.cliservice.service.BbsTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
@Service
public class BbsTopicServiceImpl extends ServiceImpl<BbsTopicMapper, BbsTopic> implements BbsTopicService {
    @Resource
    private BbsTopicMapper bbsTopicMapper;
    @Override
    public IPage<TopicListQuery> findByPage(IPage<TopicListQuery> pageTopic, TopicListQuery topicListQuery) {
        IPage<TopicListQuery> topicListQueryIPage = bbsTopicMapper.findByPage(pageTopic, topicListQuery);
        return topicListQueryIPage;
    }

    @Override
    public void addViewCount(int topicId) {
        bbsTopicMapper.addViewCount(topicId);
    }

    @Override
    public List<TopicListQuery> listAll(String plateName) {
        List<TopicListQuery> list = bbsTopicMapper.listAll(plateName);
        return list;
    }

}
