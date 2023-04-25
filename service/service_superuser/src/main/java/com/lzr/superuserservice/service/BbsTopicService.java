package com.lzr.superuserservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzr.superuserservice.entity.BbsTopic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzr.superuserservice.entity.vo.BbsTopicQuery;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
public interface BbsTopicService extends IService<BbsTopic> {
    IPage<BbsTopicQuery> findByPage(IPage<BbsTopicQuery> pageTopic, BbsTopicQuery bbsTopicQuery);

    IPage<BbsTopicQuery> findAuditByPage(IPage<BbsTopicQuery> pageTopic, BbsTopicQuery bbsTopicQuery);
}
