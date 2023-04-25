package com.lzr.cliservice.entity;

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
 * @since 2023-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BbsPlate对象", description="")
public class BbsPlate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "板块id")
    @TableId(value = "plate_id", type = IdType.AUTO)
    private Integer plateId;

    @ApiModelProperty(value = "板块名字")
    private String plateName;

    @ApiModelProperty(value = "板块介绍")
    private String plateIntroduce;

    @ApiModelProperty(value = "板块logo")
    private String plateImage;


}
