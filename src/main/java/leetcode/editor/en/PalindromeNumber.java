package leetcode.editor.en;

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward. 
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// Example 1:
//
//Input: 121
//Output: true
// 
//
// Example 2: 
//
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
// Example 3: 
//
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 从右向左读, 为 01 。因此它不是一个回文数。
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string?
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics Math

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(11222));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int tmp = x;
            long rs = 0;
            while (x != 0) {
                rs = rs * 10 + x % 10;
                x /= 10;
            }
            if (tmp == (int)rs) {
                return true;
            } else {
                return false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}