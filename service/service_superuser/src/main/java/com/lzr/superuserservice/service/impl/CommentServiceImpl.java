package com.lzr.superuserservice.service.impl;

import com.lzr.superuserservice.entity.Comment;
import com.lzr.superuserservice.mapper.CommentMapper;
import com.lzr.superuserservice.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
