package com.lzr.superuserservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.BbsUser;
import com.lzr.superuserservice.entity.vo.BbsUserQuery;
import com.lzr.superuserservice.service.BbsUserService;
import io.swagger.annotations.ApiOperation;
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
 * @since 2023-03-05
 */
@RestController
@RequestMapping("/superuserservice/bbsuser")
@CrossOrigin
public class BbsUserController {
    @Autowired
    private BbsUserService bbsUserService;

    @PostMapping("addUser")
    public R addUser(@RequestBody BbsUser user){
        boolean save = bbsUserService.save(user);
        return save ? R.ok():R.error();
    }
    @GetMapping("getUserInfo/{id}")
    public R getUserInfo(@PathVariable String id){
        return R.ok().data("user",bbsUserService.getById(id));
    }

    @ApiOperation("条件查询用户")
    @PostMapping("getUserListPage/{current}/{limit}")
    public R getUserListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) BbsUserQuery bbsUserQuery){
        Page<BbsUser> pageUser = new Page<>(current,limit);
        QueryWrapper<BbsUser> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        Integer userId = bbsUserQuery.getUserId();
        String power = bbsUserQuery.getPower();
        String username = bbsUserQuery.getUsername();
        String createTime = bbsUserQuery.getCreateTime();
        String modifiedTime = bbsUserQuery.getModifiedTime();
        if(!StringUtils.isEmpty(userId)){
            wrapper.eq("user_id",userId);
        }
        if(!StringUtils.isEmpty(power)){
            wrapper.eq("power",power);
        }
        if(!StringUtils.isEmpty(username)){
            wrapper.like("username",username);
        }
        if(!StringUtils.isEmpty(createTime)){
            wrapper.ge("create_time",createTime);
        }
        if(!StringUtils.isEmpty(modifiedTime)){
            wrapper.le("modified_time",modifiedTime);
        }
        bbsUserService.page(pageUser,wrapper);
        List<BbsUser> list = pageUser.getRecords();
        long total = pageUser.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @DeleteMapping("removeUser/{id}")
    public R removeUser(@PathVariable String id){
        BbsUser byId = bbsUserService.getById(id);
        if (byId==null){
            return R.error();
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        boolean flag = bbsUserService.remove(wrapper);
        if(flag){
            return R.ok();
        }
        else{
            return R.error();
        }
    }

    @PostMapping("updateUser")
    public R updateUser(@RequestBody BbsUser user){
        return bbsUserService.updateById(user) ? R.ok():R.error();
    }
}

