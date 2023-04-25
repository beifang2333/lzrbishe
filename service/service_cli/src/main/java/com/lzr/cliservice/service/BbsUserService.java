package com.lzr.cliservice.service;

import com.lzr.cliservice.entity.BbsUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2023-04-06
 */
public interface BbsUserService extends IService<BbsUser> {

    String login(BbsUser userInfo);
}
