/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/20  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.des;

import com.hundsun.hsap.des.DES;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-20
 */
@Slf4j
public class DesTest {

    public static void main(String[] args) {

        String s = DES.desStrEnc("gyyhkey", "1004061423");
        log.info(s);
    }
}
