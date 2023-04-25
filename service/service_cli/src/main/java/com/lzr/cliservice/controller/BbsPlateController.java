package com.lzr.cliservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzr.cliservice.entity.BbsPlate;
import com.lzr.cliservice.service.BbsPlateService;
import com.lzr.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/cliservice/bbsplate")
@CrossOrigin
public class BbsPlateController {
    @Autowired
    private BbsPlateService bbsPlateService;

    @ApiOperation("查询所有板块")
    @GetMapping("getPlateList")
    public R getPlateList(){
        QueryWrapper<BbsPlate> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("plate_name");
        List<BbsPlate> list = bbsPlateService.list(wrapper);
        return R.ok().data("list",list);
    }

}

