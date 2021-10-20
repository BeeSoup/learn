/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/9/28  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PcParamInterTableFieldVO implements Serializable {
    /**
     * 主键
     */
    private String id;


    /**
     * 所属接口表
     */
    private String paramInterTableId;

    /**
     * sheet名称
     */
    private String tableNameCn;


    private String subParamInterTableId;

    /**
     * 低码平台所属字段
     */
    private String paramFieldOwned;

    /**
     * 低码平台所属表
     */
    private String paramTableOwned;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段中文名
     */
    private String fieldNameCn;

    /**
     * 字段类型
     */
    private String paramDbType;


    /**
     * 是否为主键
     */
    private String isPrimaryKey;

    /**
     * 参数表字段默认值
     */
    private String paramFieldDefaultValue;

    /**
     * 通用状态： 01:正常， 02：失效
     */
    private String enabled;

    /**
     * 字段取值范围
     */
    private String fieldValueType;
    /**
     * 字段对应字典
     */
    private String fieldDictKey;

    /**
     * 字段排序
     */
    private String paramSort;

    /**
     * 格式化类型
     */
    private String formatType;

    /**
     * 关联的参数集
     */
    private String paramDefinitionId;

    /**
     * 字典映射关系
     */
    private String dictRelData;

    /**
     * 关联表Id
     */
    private String relId;


    private String creatorName;


    private BigDecimal createTime;


    private String lastModifyName;


    private BigDecimal lastModifyTime;
}
