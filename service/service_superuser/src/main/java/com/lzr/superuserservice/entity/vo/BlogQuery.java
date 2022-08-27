package com.lzr.superuserservice.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogQuery implements Serializable {
    private String blogId;

    private String author;

    private String title;

    private String createTime;

    private String modifiedTime;
}
