package com.lzr.cliservice.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PostList implements Serializable {
    @ApiModelProperty(value = "回复id")
    private Integer postId;

    @ApiModelProperty(value = "回复内容")
    private String postContent;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "回帖时间")
    private Date postTime;

    private String userImage;

    private String userName;
}
