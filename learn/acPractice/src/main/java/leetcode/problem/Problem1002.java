///*
// * 软件版权: 恒生电子股份有限公司
// * 修改记录:
// * 修改日期     修改人员  修改说明
// * ========    =======  ============================================
// * 2020/10/14  zhang  新增
// * ========    =======  ============================================
// */
//
//package leetcode.problem;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 功能说明:
// * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
// * <p>
// * 你可以按任意顺序返回答案。
// * <p>
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/find-common-characters
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// *
// * @author zhang
// * @Date 2020/10/14
// */
//public class Problem1002 {
//
//    public static void main(String[] args) {
//        String[] A = {"bella", "label", "roller"};
//        commonChars(A);
//    }
//
//    public static List<String> commonChars(String[] A) {
//        /**
//         * 如果把这个题目当成一个过滤的题目，第一个字符就是满串，后续都是基于这个满串过滤
//         * 注：包含多个需要输出多个
//         */
//        if (A.length < 1) {
//            return Collections.emptyList();
//        }
//        String one = A[0];
//        char[] chars = one.toCharArray();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Character c : chars) {
//            if (map.containsKey(c)) {
//                Integer integer = map.get(c);
//                integer++;
//            }
//            map.put(c.hashCode(), 0);
//        }
//        return Collections.emptyList();
//    }
//
//    /**
//     * 计数，倍数。以第一个字符串为倍数 没有的情况加上
//     */
//    public static List<String> commonChars2(String[] A) {
//        List<String> result = new ArrayList<>();
//        int[] multiple = new int[26];
//        int[] sum = new int[26];
//        // 第一个字符串
//        String one = A[0];
//        char[] chars = one.toCharArray();
//        for (char c : chars) {
//            int i = c - 'a';
//            multiple[i]++;
//        }
//        for (String B : A) {
//            for (Character c : B.toCharArray()) {
//                int i = c - 'a';
//                if (multiple[i] > 0) {
//                    sum[i]++;
//                } else {
//                    multiple[i] = 0;
//                }
//            }
//        }
//        for (int i = 0; i < 26; i++) {
//            if (multiple[i] > 0) {
//                result;
//            }
//
//        }
//        return null;
//    }
//
//
//}
