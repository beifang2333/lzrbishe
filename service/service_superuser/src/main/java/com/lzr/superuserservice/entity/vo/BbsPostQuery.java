package com.lzr.superuserservice.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BbsPostQuery implements Serializable {
    private String postId;

    private String username;

    private String topic;

    private String postContent;

    private String topicId;

    private String postTime;

    private String endTime;

    private String status;

}
