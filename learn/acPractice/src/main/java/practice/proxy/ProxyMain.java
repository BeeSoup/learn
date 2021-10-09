/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/9  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-09
 */
@Slf4j
public class ProxyMain {

    public static void main(String[] args) {
        Target instant = ProxyFactory.getInstant(Execute.class);
        String execute = instant.execute2();
        log.info("instant:{}", execute);
        Target instant2 = ProxyFactory.getInstant(() -> {
            log.info("匿名内置类 JAVA8模式");
            return "yes";
        });
        String execute1 = instant2.execute();
        log.info("instant2:{}", execute1);


        Execute cgInstant = ProxyFactory.getCGInstant(Execute.class);
        String cgResult = cgInstant.execute2();
        log.info("cgResult:{}", cgResult);


    }
}
