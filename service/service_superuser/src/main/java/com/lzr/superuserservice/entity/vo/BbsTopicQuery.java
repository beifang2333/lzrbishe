package com.lzr.superuserservice.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BbsTopicQuery implements Serializable {
    private Integer topicId;

    private String topic;

    private String content;

    private String plateName;

    private String username;

    private Integer viewCount;

    private String status;

    private Integer topicLevel;

    private Date createTime;

    private Date modifiedTime;

}
