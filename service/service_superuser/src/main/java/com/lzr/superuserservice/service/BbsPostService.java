package com.lzr.superuserservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.superuserservice.entity.BbsPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzr.superuserservice.entity.vo.BbsPostQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
public interface BbsPostService extends IService<BbsPost> {
    IPage<BbsPostQuery> findByPage(IPage<BbsPostQuery> pagePost, BbsPostQuery bbsPostQuery);

    IPage<BbsPostQuery> findAuditByPage(Page<BbsPostQuery> pagePost, BbsPostQuery bbsPostQuery);
}
