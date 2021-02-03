package leetcode.editor.cn;

// 2021-01-05 09:13:35-633

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 160 👎 0


public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        boolean res = solution.judgeSquareSum(5);
        res = solution.judgeSquareSum(4);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean judgeSquareSum1(int c) {
            if (c == 0) {
                return true;
            }
            int number = (int) Math.sqrt(c);
            // 特别注意，左边界应该是从0开始的
            int start = 0, end = number;
            while (start <= end) {
                int sum = start * start + end * end;
                if ( sum == c) {
                    return true;
                } else if (sum < c) {
                    start ++;
                } else {
                    end--;
                }
            }

            return false;
        }

        // https://leetcode-cn.com/problems/sum-of-square-numbers/solution/ping-fang-shu-zhi-he-by-leetcode/
        public boolean judgeSquareSum(int c) {
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a*a);
                if (b == (int)b) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}