package com.lzr.cliservice.mapper;

import com.lzr.cliservice.entity.BbsPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzr.cliservice.entity.vo.PostList;
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
public interface BbsPostMapper extends BaseMapper<BbsPost> {
    List<PostList> findPostList(@Param("topicId") int topicId);
}
