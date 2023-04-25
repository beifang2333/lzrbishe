package com.lzr.superuserservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.superuserservice.entity.BbsPost;
import com.lzr.superuserservice.entity.vo.BbsPostQuery;
import com.lzr.superuserservice.mapper.BbsPostMapper;
import com.lzr.superuserservice.mapper.BbsUserMapper;
import com.lzr.superuserservice.service.BbsPostService;
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
public class BbsPostServiceImpl extends ServiceImpl<BbsPostMapper, BbsPost> implements BbsPostService {
//    @Resource
//    private BbsUserMapper bbsUserMapper;
    @Resource
    private BbsPostMapper bbsPostMapper;
//    @Override
//    public IPage<BbsPost> findByPage(IPage<BbsPost> pageBbsPost, BbsPost bbsPost) {
//        IPage<BbsPost> BbsPostIPage = bbsPostMapper.findByPage(pageBbsPost, bbsPost);
//        return BbsPostIPage;
//    }

    @Override
    public IPage<BbsPostQuery> findByPage(IPage<BbsPostQuery> pagePost, BbsPostQuery bbsPostQuery) {
        IPage<BbsPostQuery> BbsPostIPage = bbsPostMapper.findByPage(pagePost, bbsPostQuery);
        return BbsPostIPage;
    }

    @Override
    public IPage<BbsPostQuery> findAuditByPage(Page<BbsPostQuery> pagePost, BbsPostQuery bbsPostQuery) {
        IPage<BbsPostQuery> BbsPostIPage = bbsPostMapper.findAuditByPage(pagePost, bbsPostQuery);
        return BbsPostIPage;
    }
}
