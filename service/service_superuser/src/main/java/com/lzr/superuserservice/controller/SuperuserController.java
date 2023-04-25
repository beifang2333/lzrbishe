package com.lzr.superuserservice.controller;

import com.lzr.commonutils.JwtUtils;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.Superuser;
import com.lzr.superuserservice.service.SuperuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2022-08-23
 */
@RestController
@RequestMapping("/superuserservice/superuser")
@CrossOrigin
public class SuperuserController {
    @Autowired
    private SuperuserService superuserService;

    @PostMapping("login")
    public R login(@RequestBody Superuser superuserInfo){
        String token = superuserService.login(superuserInfo);
        return R.ok().data("token",token);
    }
    @PostMapping("logout")
    public R logout(){
//        String token = superuserService.login(superuserInfo);
        return R.ok().data("token",null);
    }

    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        //调用jwt工具类，获取头部信息，返回用户id
        String superuserId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据id获得用户信息
        Superuser superuser = superuserService.getById(superuserId);
        return R.ok().data("superuserInfo",superuser);
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","http://edu-longyang.oss-cn-beijing.aliyuncs.com/2020/08/05/25f411209c8b44b9b003482b6265c3c9file.png");
    }
}

