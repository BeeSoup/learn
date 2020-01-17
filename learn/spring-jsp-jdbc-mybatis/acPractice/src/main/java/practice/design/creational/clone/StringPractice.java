package practice.design.creational.clone;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/2 10:40
 */
public class StringPractice {
    public static void main(String[] args) {
        String msg = "测试打c:d带我去玩e:f武器g:1234,2344,252141,22115";
        StringBuffer sb = new StringBuffer();
        int length = msg.length();
        int last = msg.lastIndexOf(":");
        if (last != -1) {
            String[] split = msg.substring(last + 1, length).split(",");
            List<Long> listIds = new ArrayList<Long>();
            for (String id : split) {
                try {
                    Long InstructionId = Long.valueOf(id);
                    listIds.add(InstructionId);
                } catch (Exception e) {
//                  如果转换异常不管
                }
            }
            final int size = listIds.size();
            Long[] InstructionIds = listIds.toArray(new Long[size]);

            System.out.println(InstructionIds);
        }

    }
}
