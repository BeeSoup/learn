package practice.excel;/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/8/26  zhangyu30939  新增
 * ========    =======  ============================================
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 功能说明:  子节点信息
 *
 * @author zhangyu30939
 * @date 021/8/26
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SubStatusEnum {
    /**
     * 子节点信息:字段
     */
    PC_PARAM_ZJDZT_FIELD("01", "字段"),
    /**
     * 子节点信息:SHEET
     */
    PC_PARAM_ZJDZT_SHEET("02", "SHEET"),
    ;

    private String code;

    private String description;

    public static SubStatusEnum getEnumByCode(String code) {
        for (SubStatusEnum enumEntity : SubStatusEnum.values()) {
            if (code.equals(enumEntity.getCode())) {
                return enumEntity;
            }
        }
        return null;
    }

    /**
     * 获取code对应的desc
     *
     * @param code 编码
     * @return 描述
     */
    public static String getDesc(String code) {
        SubStatusEnum[] values = values();
        for (SubStatusEnum value : values) {
            if (value.getCode().equals(code)) {
                return value.getDescription();
            }
        }
        return null;
    }
}
