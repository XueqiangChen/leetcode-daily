package leetcode.editor.en;

//Given a 32-bit signed integer, reverse digits of an integer.
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics Math

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int x = 123;
        System.out.println(solution.reverse(x));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long rs = 0;
            while(x != 0){
                rs = rs*10+x%10;
                x /= 10;
            }
            return (rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) ? 0:(int)rs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}