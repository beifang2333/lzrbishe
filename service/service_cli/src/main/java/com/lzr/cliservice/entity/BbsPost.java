package com.lzr.cliservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BbsPost对象", description="")
public class BbsPost implements Serializable {

//    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回复id")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    @ApiModelProperty(value = "回复内容")
    private String postContent;

    @ApiModelProperty(value = "主题id")
    private Integer topicId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "回帖时间")
    private Date postTime;

    @ApiModelProperty(value = "状态")
    private String status;

}
