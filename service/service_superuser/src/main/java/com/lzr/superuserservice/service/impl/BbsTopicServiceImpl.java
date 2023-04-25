package com.lzr.superuserservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzr.superuserservice.entity.BbsTopic;
import com.lzr.superuserservice.entity.vo.BbsTopicQuery;
import com.lzr.superuserservice.mapper.BbsTopicMapper;
import com.lzr.superuserservice.service.BbsTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
@Service
public class BbsTopicServiceImpl extends ServiceImpl<BbsTopicMapper, BbsTopic> implements BbsTopicService {
    @Resource
    private BbsTopicMapper bbsTopicMapper;
    @Override
    public IPage<BbsTopicQuery> findByPage(IPage<BbsTopicQuery> pageBbsTopic, BbsTopicQuery bbsTopicQuery) {
        IPage<BbsTopicQuery> BbsTopicQueryIPage = bbsTopicMapper.findByPage(pageBbsTopic, bbsTopicQuery);
        return BbsTopicQueryIPage;
    }
    @Override
    public IPage<BbsTopicQuery> findAuditByPage(IPage<BbsTopicQuery> pageBbsTopic, BbsTopicQuery bbsTopicQuery) {
        IPage<BbsTopicQuery> BbsTopicQueryIPage = bbsTopicMapper.findAuditByPage(pageBbsTopic, bbsTopicQuery);
        return BbsTopicQueryIPage;
    }
}
