package com.lzr.superuserservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzr.commonutils.JwtUtils;
import com.lzr.servicebase.exceptionhandler.GuliException;
import com.lzr.superuserservice.entity.Superuser;
import com.lzr.superuserservice.mapper.SuperuserMapper;
import com.lzr.superuserservice.service.SuperuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzr
 * @since 2022-08-23
 */
@Service
public class SuperuserServiceImpl extends ServiceImpl<SuperuserMapper, Superuser> implements SuperuserService {

    @Override
    public String login(Superuser superuserInfo) {
        String username = superuserInfo.getUsername();
        String password = superuserInfo.getPassword();
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new GuliException(20001,"账号或密码为空");
        }
        QueryWrapper<Superuser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        Superuser superuser = baseMapper.selectOne(wrapper);
        if (superuser==null){
            throw new GuliException(20001,"账号或密码错误");
        }
        String token = JwtUtils.getJwtToken(superuser.getId().toString(), superuser.getUsername());
        return token;
    }
}
