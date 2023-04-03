package com.lzr.superuserservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzr.commonutils.R;
import com.lzr.superuserservice.entity.BbsPlate;
import com.lzr.superuserservice.entity.vo.PlateQuery;
import com.lzr.superuserservice.service.BbsPlateService;
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
@RequestMapping("/superuserservice/bbs-plate")
@CrossOrigin
public class BbsPlateController {
    @Autowired
    private BbsPlateService bbsPlateService;

    @ApiOperation("添加板块")
    @PostMapping("addBbsPlate")
    public R addUser(@RequestBody BbsPlate bbsPlate){
        boolean save = bbsPlateService.save(bbsPlate);
        return save ? R.ok():R.error();
    }

    @GetMapping("getBbsPlateInfo/{id}")
    public R getBbsPlateInfo(@PathVariable String id){
        return R.ok().data("plate",bbsPlateService.getById(id));
    }

    @ApiOperation("条件查询板块")
    @PostMapping("getPlateListPage/{current}/{limit}")
    public R getPlateListPage(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) PlateQuery plateQuery){
        Page<BbsPlate> bbsPlatePage = new Page<>(current,limit);
        QueryWrapper<BbsPlate> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("plate_name");
        String name = plateQuery.getPlateName();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("plate_name",name);
        }
        bbsPlateService.page(bbsPlatePage,wrapper);
        List<BbsPlate> list = bbsPlatePage.getRecords();
        long total = bbsPlatePage.getTotal();
        return R.ok().data("list",list).data("total",total);
    }

    @ApiOperation("删除板块")
    @DeleteMapping("removePlate/{id}")
    public R removeUser(@PathVariable String id){
        BbsPlate byId = bbsPlateService.getById(id);
        if (byId==null){
            return R.error();
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plate_id",id);
        boolean flag = bbsPlateService.remove(wrapper);
        if(flag){
            return R.ok();
        }
        else{
            return R.error();
        }
    }

    @ApiOperation("更新板块")
    @PostMapping("updateBbsPlate")
    public R updateBbsPlate(@RequestBody BbsPlate bbsPlate){
        return bbsPlateService.updateById(bbsPlate) ? R.ok():R.error();
    }
}

