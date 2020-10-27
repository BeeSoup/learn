package com.zhangyu.service.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名称
     */
    private String name;
}
