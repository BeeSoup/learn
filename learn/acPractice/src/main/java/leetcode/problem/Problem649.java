/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/12/11  zhang  新增
 * ========    =======  ============================================
 */

package leetcode.problem;

import java.util.LinkedList;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/12/11
 */
public class Problem649 {

    /**
     * 首先
     * 	贪心算法：
     * 		不管是天辉还是夜魇参议院都会禁用最近的议员权利
     * 		其二，这个列将会的一个圆环
     * 		
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "DDR";
        predictPartyVictory(str);
    }

    public static void predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        Character[] objects = senate.chars().mapToObj(c -> {
            return Character.valueOf((char) c);
        }).toArray(Character[]::new);
        // , LinkedList::offer,
        LinkedList<Character> linkedList = senate.chars().mapToObj(c -> {
            return Character.valueOf((char) c);
        }).collect(Collectors.toCollection((Supplier<LinkedList<Character>>) LinkedList::new));
        Character dire = 'D';
        Character radiant = 'R';
        // List<Character> chars1 = Arrays.asList(objects);
        // LinkedList<Character> queue = new LinkedList<Character>(chars1);

    }
}
