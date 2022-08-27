package com.lzr.superuserservice.service;

import com.lzr.superuserservice.entity.Superuser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzr
 * @since 2022-08-23
 */
public interface SuperuserService extends IService<Superuser> {

    String login(Superuser superuserInfo);
}
