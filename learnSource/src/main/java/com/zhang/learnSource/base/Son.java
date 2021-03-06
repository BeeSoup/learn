/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/1/18  zhang  新增
 * ========    =======  ============================================
 */

package com.zhang.learnSource.base;

import lombok.Data;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2021/01/18
 */
@Data
public class Son extends Parent {
    private String sonData;

    private int k;

    public static void main(String[] args) {
        Son son = new Son();
        String data = son.getData();
        son.sys();
    }

    public void sys() {
        int i;
        System.out.println(k); // 正常0
        // System.out.println(i); // 编译报错
    }
}



