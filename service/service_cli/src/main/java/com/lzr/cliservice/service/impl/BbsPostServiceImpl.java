package com.lzr.cliservice.service.impl;

import com.lzr.cliservice.entity.BbsPost;
import com.lzr.cliservice.entity.vo.PostList;
import com.lzr.cliservice.mapper.BbsPostMapper;
import com.lzr.cliservice.mapper.BbsTopicMapper;
import com.lzr.cliservice.mapper.BbsUserMapper;
import com.lzr.cliservice.service.BbsPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class BbsPostServiceImpl extends ServiceImpl<BbsPostMapper, BbsPost> implements BbsPostService {
    @Resource
    private BbsPostMapper bbsPostMapper;
    @Override
    public List<PostList> findPostList(int topicId) {
        List<PostList> list = bbsPostMapper.findPostList(topicId);
        return list;
    }
}
