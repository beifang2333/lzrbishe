package com.lzr.superuserservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzr
 * @since 2023-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BbsTopic对象", description="")
public class BbsTopic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主题id")
    @TableId(value = "topic_id", type = IdType.AUTO)
    private Integer topicId;

    @ApiModelProperty(value = "主题")
    private String topic;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "板块名字")
    private String plateName;

    private String userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    private Long viewCount;

    @ApiModelProperty(value = "审核状态 Draft未发布  Normal已发布")
    private String status;

    @ApiModelProperty(value = "排名级别")
    private Integer topicLevel;

    private Integer isDeleted;

    @ApiModelProperty(value = "发布时间")
    private String createTime;

    private String modifiedTime;


}
