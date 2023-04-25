package com.lzr.cliservice.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TopicListQuery implements Serializable {
    private Integer topicId;

    private String topic;

    private String plateName;

    private String content;

    private String userImage;

    private String username;

    private Date createTime;

    private Integer viewCount;
}
