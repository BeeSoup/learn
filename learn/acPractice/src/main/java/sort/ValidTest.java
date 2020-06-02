package sort;

public class ValidTest {

    /**
     * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
     * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。缩写中的数字 表示其缩略略的字符数;连续多位数字表示⼀一个多位数。
     * 例例如，字符串串 “word” 的缩写有且仅有以下这些:[“word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", “4"]。
     * 例例 1:输⼊入:s = “internationalization"，abbr = "i12iz4n" 返回:true
     * 解释:abbr 中的 12 表示有⼗十⼆二个字符被缩略略了了。 例例 2:输⼊入:s = “apple"，abbr = “a2e"
     * 返回:false
     */

    public static void main(String[] args) {
        String word = "internationalization";
        String addr = "i12iz4n";
        char num = '1';
        System.out.printf("char : %d\n", num - 48);
        boolean valid = valid(word, addr);
        System.out.printf("result : %s\n", valid);

        boolean valid1 = valid("apple", "a2e");
        System.out.printf("result : %s\n", valid1);
    }

    /**
     * 以缩略地址为基准，主格比较即可
     */
    static boolean valid(String word, String abbr) {
        char[] workChar = word.toCharArray();
        char[] abbrChar = abbr.toCharArray();
        int num = 0;
        int workIndex = 0;
        int abbrIndex = 0;
        for (; abbrIndex < abbrChar.length; abbrIndex++) {
            if (Character.isLowerCase(abbrChar[abbrIndex])) {
                if (num != 0) {
                    workIndex = workIndex + num;
                    num = 0;
                }
                System.out.printf(" workChar: %s, workIndex :%d, abbrChar: %s ,addrIndex: %d \n", workChar[workIndex],
                        workIndex, abbrChar[abbrIndex], abbrIndex);
                if (workChar[workIndex] != abbrChar[abbrIndex]) {
                    return false;
                }
                workIndex++;
            } else {
                num = (10 * num) + abbrChar[abbrIndex] - 48;
                System.out.printf(" num: %d\n", num);
                if (abbrIndex + 1 == abbrChar.length) {
                    workIndex = workIndex + num;
                    num = 0;
                }
            }
            System.out.printf(" workIndex: %d, abbrIndex:%d  \n", workIndex, abbrIndex + 1);
            if (workIndex == workChar.length && abbrIndex + 1 == abbrChar.length) {
                return true;
            }
        }
        return false;
    }
}
