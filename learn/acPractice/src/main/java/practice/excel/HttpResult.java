/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/9/3  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResult<T> implements Serializable {

    private String code;
    private String msg;

    private String returnCode;
    private String errorCode;
    private String errorMessage;
    private String errorProperties;

    private T result;

    private T data;

}
