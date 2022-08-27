package com.lzr.superuserservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.User;
import com.lzr.superuserservice.entity.vo.UserQuery;
import com.lzr.superuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2022-08-24
 */
@RestController
@RequestMapping("/superuserservice/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public R addUser(@RequestBody User user){
        boolean save = userService.save(user);
        return save ? R.ok():R.error();
    }
    @GetMapping("getUserInfo/{id}")
    public R getUserInfo(@PathVariable String id){
        return R.ok().data("user",userService.getById(id));
    }

    @PostMapping("getUserListPage/{current}/{limit}")
    public R getUserListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) UserQuery userQuery){
        Page<User> pageUser = new Page<>(current,limit);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        String name = userQuery.getName();
        String begin = userQuery.getCreateTime();
        String end = userQuery.getModifiedTime();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("create_time",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("modified_time",end);
        }
        userService.page(pageUser,wrapper);
        List<User> list = pageUser.getRecords();
        long total = pageUser.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @DeleteMapping("removeUser/{id}")
    public R removeUser(@PathVariable String id){
        User byId = userService.getById(id);
        if (byId==null){
            return R.error();
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uid",id);
        boolean flag = userService.remove(wrapper);
        if(flag){
            return R.ok();
        }
        else{
            return R.error();
        }
    }

    @PostMapping("updateUser")
    public R updateUser(@RequestBody User user){
        return userService.updateById(user) ? R.ok():R.error();
    }
}

