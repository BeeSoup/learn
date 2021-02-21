package com.zy.newsourcce.pojo.datasource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Api的类型", description = "UserDTO文档说明")
public class UserDTO implements Serializable {

    @ApiModelProperty(value = "id文档说明", name = "id", required = true)
    private String id;
}
