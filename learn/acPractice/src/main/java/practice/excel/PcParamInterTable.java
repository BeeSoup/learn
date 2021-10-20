package practice.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2021-10-18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PcParamInterTable implements Serializable {

    /**
     * 规避恒生规约扫描
     */
    private static final long serialVersionUID = 1L;

    /**
     * 规避恒生规约扫描
     */
    private String id;

    /**
     * 规避恒生规约扫描
     */
    private String tableName;

    /**
     * 规避恒生规约扫描
     */
    private String tableNameCn;

    /**
     * 规避恒生规约扫描
     */
    private String source;

    /**
     * 规避恒生规约扫描
     */
    private String paramOperateFlag;

    /**
     * 规避恒生规约扫描
     */
    private String enabled;

    /**
     * 规避恒生规约扫描
     */
    private String parentId;

    /**
     * 规避恒生规约扫描
     */
    private String tableSort;

    /**
     * 规避恒生规约扫描
     */
    private String subStatus;

    /**
     * 规避恒生规约扫描
     */
    private String exportType;

    /**
     * 规避恒生规约扫描
     */
    private String exportName;

    /**
     * 规避恒生规约扫描
     */
    private String paramConfigInfo;

    /**
     * 规避恒生规约扫描
     */
    private String creatorName;

    /**
     * 规避恒生规约扫描
     */
    private BigDecimal createTime;

    /**
     * 规避恒生规约扫描
     */
    private String lastModifyName;

    /**
     * 规避恒生规约扫描
     */
    private BigDecimal lastModifyTime;
}
