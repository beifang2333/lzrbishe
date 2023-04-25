package com.lzr.superuserservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzr.superuserservice.entity.BbsTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzr.superuserservice.entity.vo.BbsTopicQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
@Mapper
public interface BbsTopicMapper extends BaseMapper<BbsTopic> {
    IPage<BbsTopicQuery> findByPage(IPage<BbsTopicQuery> page, @Param("bbsTopic") BbsTopicQuery bbsTopicQuery);

    IPage<BbsTopicQuery> findAuditByPage(IPage<BbsTopicQuery> pageBbsTopic,@Param("bbsTopic") BbsTopicQuery bbsTopicQuery);
}
