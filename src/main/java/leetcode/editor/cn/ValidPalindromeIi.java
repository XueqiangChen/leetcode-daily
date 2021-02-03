package leetcode.editor.cn;

// 2021-01-06 09:08:03-680

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 305 👎 0


public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 考虑最朴素的方法：首先判断原串是否是回文串，如果是，就返回 true；如果不是，则枚举每一个位置作为被删除的位置，再判断剩下的字符串是否是回文串。这种做法的渐进时间复杂度是 O(n^2)的，会超出时间限制。
         *
         * 我们换一种想法。首先考虑如果不允许删除字符，如何判断一个字符串是否是回文串。常见的做法是使用双指针。定义左右指针，初始时分别指向字符串的第一个字符和最后一个字符，每次判断左右指针指向的字符是否相同，
         * 如果不相同，则不是回文串；如果相同，则将左右指针都往中间移动一位，直到左右指针相遇，则字符串是回文串。
         *
         * 在允许最多删除一个字符的情况下，同样可以使用双指针，通过贪心算法实现。初始化两个指针 low 和 high 分别指向字符串的第一个字符和最后一个字符。每次判断两个指针指向的字符是否相同，如果相同，则更新指针，
         * 令 low = low + 1 和 high = high - 1，然后判断更新后的指针范围内的子串是否是回文字符串。如果两个指针指向的字符不同，则两个字符中必须有一个被删除，此时我们就分成两种情况：即删除左指针对应的字符，
         * 留下子串 s[low + 1], s[low + 2], ..., s[high]，或者删除右指针对应的字符，留下子串 s[low], s[low + 1], ..., s[high - 1]。当这两个子串中至少有一个是回文串时，就说明原始字符串删除一个字符之后就以成为回文串。
         *
         * @param s
         * @return
         */
        public boolean validPalindrome(String s) {
            if (s == null || s.length() < 0) {
                return false;
            }
            if (s.length() == 1) {
                return true;
            }

            char[] strArray = s.toCharArray();
            int start = 0, end = strArray.length - 1;
            while (start < end) {
                char left = strArray[start];
                char right = strArray[end];

                if (left == right) {
                    start++;
                    end--;
                } else {
                    // abca
                    boolean flag1 = true, flag2 = true;
                    // [start, end - 1]
                    for (int i = start, j = end - 1; i < j; i++, j--) {
                        char c3 = s.charAt(i), c4 = s.charAt(j);
                        if (c3 != c4) {
                            flag1 = false;
                            break;
                        }
                    }
                    // [start+1, end]
                    for (int i = start + 1, j = end; i < j; i++, j--) {
                        char c3 = s.charAt(i), c4 = s.charAt(j);
                        if (c3 != c4) {
                            flag2 = false;
                            break;
                        }
                    }

                    return flag1 || flag2;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}