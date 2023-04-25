package com.lzr.cliservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzr.cliservice.entity.BbsUser;
import com.lzr.cliservice.mapper.BbsUserMapper;
import com.lzr.cliservice.service.BbsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzr.commonutils.JwtUtils;
import com.lzr.servicebase.exceptionhandler.GuliException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
@Service
public class BbsUserServiceImpl extends ServiceImpl<BbsUserMapper, BbsUser> implements BbsUserService {

    @Override
    public String login(BbsUser userInfo) {
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new GuliException(20001,"账号或密码为空");
        }
        QueryWrapper<BbsUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        BbsUser bbsUser = baseMapper.selectOne(wrapper);
        if (bbsUser==null){
            throw new GuliException(20001,"账号或密码错误");
        }
        String token = JwtUtils.getJwtToken(bbsUser.getUserId().toString(), bbsUser.getUsername());
        return token;
    }
}
