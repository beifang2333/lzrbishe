package com.lzr.superuserservice.entity.vo;

import lombok.Data;

@Data
public class BbsUserQuery {
    private Integer userId;

    private String username;

    private String power;

    private String createTime;

    private String modifiedTime;
}
