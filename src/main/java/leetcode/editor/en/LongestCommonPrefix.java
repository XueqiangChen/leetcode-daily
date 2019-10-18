package leetcode.editor.en;

//Write a function to find the longest common prefix string amongst an array of strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 解题方法参考：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
//            return mehtod1(strs);
            return method2(strs);
        }

    }

    public static String method3(String[] strs) {
        /**
         * 首先，我们将描述一种查找一组字符串的最长公共前缀LCP(S1...Sn)的简单方法。
         * 我们将会用到这样的结论：
         * LCP(S1...Sn) = LCP(LCP(LCP(S1,S2),S3),...Sn)
         *
         * 算法：
         * 为了运用这种思想，算法要依次遍历字符串[S1...Sn]，当遍历到第 ii 个字符串的时候，找到最长公共前缀 LCP(S1...Si)。
         * 当LCP(S1...Si) 是一个空串的时候，算法就结束了。否则，在执行n次遍历后，算法就会返回最终答案LCP(S1...Sn)
         */
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static String method2(String[] strs) {
        /**
         * 想象数组的末尾有一个非常短的字符串，使用上述方法依旧会进行 S​S​ 次比较。
         * 优化这类情况的一种方法就是水平扫描。我们从前往后枚举字符串的每一列，
         * 先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。
         */
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static String mehtod1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder commonPrefix = new StringBuilder();
        char[] firstStr = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : firstStr) {
            sb.append(c);

            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(sb.toString())) {
                    if (commonPrefix.length() == 0) {
                        return "";
                    }
                    return commonPrefix.toString();
                }
            }

            commonPrefix.append(c);
        }

        return commonPrefix.toString();
    }
//leetcode submit region end(Prohibit modification and deletion)

}