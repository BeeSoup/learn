/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/7/1  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-07-01
 */
public class NameTest {


    public static void main(String[] args) {

        List<Type> list = new ArrayList<>();

        Type type = null;
        for (int i = 0; i < 10; i++) {
            type = new Type(i, i, "name" + i);
            list.add(type);
        }

        list.stream().forEach(System.out::println);

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Type {

        private int age;
        private Integer age2;

        private String name;


    }
}
