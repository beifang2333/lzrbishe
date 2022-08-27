package com.lzr.superuserservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.superuserservice.entity.User;
import com.lzr.superuserservice.entity.vo.BlogQuery;
import com.lzr.superuserservice.entity.vo.UserQuery;
import com.lzr.superuserservice.mapper.UserMapper;
import com.lzr.superuserservice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
