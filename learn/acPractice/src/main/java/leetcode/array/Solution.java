/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/24  zhang  新增
 * ========    =======  ============================================
 */

package leetcode.array;

/**
 * 功能说明:
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 40.5 MB
 * , 在所有 Java 提交中击败了
 * 35.53%
 * 的用户
 *
 * @author zhang
 * @Date 2020/08/24
 */
public class Solution {

    class SolutionDemo {
        public int pivotIndex(int[] nums) {
            if (nums.length < 3) {
                return -1;
            }
            int sum = 0;
            int sumIndex = 0;
            for (int i = 0;i < nums.length; i++ ) {
                sum += nums[i];
            }

            for (int i = 0;i < nums.length; i++) {
                if (sumIndex == sum -sumIndex - nums[i]) {
                    return i;
                }
                sumIndex += nums[i];
            }
            return -1;
        }
    }
}
