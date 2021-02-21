package com.zy.newsourcce.pojo.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author zy
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("items")
public class Items implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 商品名称 商品名称
     */
    private String itemName;

    /**
     * 分类外键id 分类id
     */
    private Integer catId;

    /**
     * 一级分类外键id 一级分类id，用于优化查询
     */
    private Integer rootCatId;

    /**
     * 累计销售 累计销售
     */
    private Integer sellCounts;

    /**
     * 上下架状态 上下架状态,1:上架 2:下架
     */
    private Integer onOffStatus;

    /**
     * 商品内容 商品内容
     */
    private String content;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;


}
