package com.lzr.cliservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzr.cliservice.entity.BbsTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzr.cliservice.entity.vo.TopicListQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
public interface BbsTopicMapper extends BaseMapper<BbsTopic> {
    IPage<TopicListQuery> findByPage(IPage<TopicListQuery> page, @Param("topicListQuery") TopicListQuery topicListQuery);

    void addViewCount(@Param("topicId") int topicId);

    List<TopicListQuery> listAll(String plateName);
}
