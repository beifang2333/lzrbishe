package com.lzr.cliservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzr.cliservice.entity.BbsUser;
import com.lzr.cliservice.service.BbsUserService;
import com.lzr.commonutils.JwtUtils;
import com.lzr.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/cliservice/bbsuser")
@CrossOrigin
public class BbsUserController {
    @Autowired
    private BbsUserService bbsUserService;

    @GetMapping("getUserInfo/{id}")
    public R getUserInfo(@PathVariable String id){
        return R.ok().data("user",bbsUserService.getById(id));
    }

    @PostMapping("login")
    public R login(@RequestBody BbsUser userInfo){
        String token = bbsUserService.login(userInfo);
        return R.ok().data("token",token);
    }

    @PostMapping("registerUser")
    public R registerUser(@RequestBody BbsUser bbsUser){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",bbsUser.getUsername());
        if(bbsUserService.getOne(wrapper)!=null){
            return R.error().message("账户名已存在");
        }
        boolean save = bbsUserService.save(bbsUser);
        return save ? R.ok():R.error();
    }

    @GetMapping("getUserInfo")
    public R getUserInfo(HttpServletRequest request){
        //调用jwt工具类，获取头部信息，返回用户id
        String bbsUserId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据id获得用户信息
        BbsUser bbsUser = bbsUserService.getById(bbsUserId);
        return R.ok().data("UserInfo",bbsUser);
    }

    @PostMapping("updateUser")
    public R updateUser(@RequestBody BbsUser user){
        return bbsUserService.updateById(user) ? R.ok():R.error();
    }
}

