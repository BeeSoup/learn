/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/7/27  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

/**
 * 功能说明:
 * 校验异常（运行时异常）
 *
 * @author zhangyu30939
 * @Date 2020/07/27
 */
public class ValidatorException extends RuntimeException {

    public ValidatorException() {

    }

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Exception e) {
        super(message);
        initCause(e);
    }
}
