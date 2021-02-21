/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/6/24  zhangyu30939  新增
 * ========    =======  ============================================
 */
package lambda;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明: 测试一下相关的数据问题
 *
 * @author zhangyu30939
 */
@Data
@Slf4j
public class MyData {

  private String name = "default";

  public static void main(String[] args) {
    log.info("1");
  }

}
