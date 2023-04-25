package com.lzr.superuserservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzr.superuserservice.entity.BbsPost;
import com.lzr.superuserservice.entity.vo.BbsPostQuery;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
public interface BbsPostMapper extends BaseMapper<BbsPost> {
//    IPage<BbsPost> findByPage(IPage<BbsPost> pageBbsPost,@Param("bbsPost") BbsPost bbsPost);
    IPage<BbsPostQuery> findByPage(IPage<BbsPostQuery> pagePost, @Param("postQuery") BbsPostQuery bbsPostQuery);

    IPage<BbsPostQuery> findAuditByPage(IPage<BbsPostQuery> pagePost,@Param("postQuery") BbsPostQuery bbsPostQuery);
}
