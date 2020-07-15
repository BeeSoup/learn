/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/7/13  zhang  新增
 * ========    =======  ============================================
 */

package defaultdemo;

public class MyFunctionImpl implements MyFunction {

    @Override
    public String getFunction(String name) {
        return "default";
    }

    public static void main(String[] args) {
        String result = dealFunction("yes", (name) -> {
            return "ok: " + name;
        });
        System.out.println(result);

        System.out.println(dealFunction("yes", new MyFunctionImpl()));
    }


    public static String dealFunction(String name, MyFunction function) {
        String function1 = function.getFunction(name);
        return function1;
    }
}

