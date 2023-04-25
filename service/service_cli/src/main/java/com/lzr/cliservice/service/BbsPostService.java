package com.lzr.cliservice.service;

import com.lzr.cliservice.entity.BbsPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzr.cliservice.entity.vo.PostList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
public interface BbsPostService extends IService<BbsPost> {
    List<PostList> findPostList(int topicId);
}
