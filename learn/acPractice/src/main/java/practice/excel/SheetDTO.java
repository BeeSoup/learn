/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/20  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SheetDTO implements Serializable {

    private String id;

    private String tableName;

    private String tableNameCn;

    private List<PcParamInterTableFieldVO> fieldList;

}
