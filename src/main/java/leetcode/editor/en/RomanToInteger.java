package leetcode.editor.en;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. 
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II. 
//例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used: 
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况
// 
// I can be placed before V (5) and X (10) to make 4 and 9.
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X can be placed before L (50) and C (100) to make 40 and 90.
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C can be placed before D (500) and M (1000) to make 400 and 900.
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999. 
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
// Example 1: 
//
// 
//Input: "III"
//Output: 3 
//
// Example 2: 
//
// 
//Input: "IV"
//Output: 4 
//
// Example 3: 
//
// 
//Input: "IX"
//Output: 9 
//
// Example 4: 
//
// 
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics Math String

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        System.out.println(solution.romanToInt("MCDLXXVI"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
//            return method1(s);
            return method2(s);
        }
    }

    public static int method1(String s) {
        /*
        思路:
        * 首先将所有的组合可能性列出并添加到哈希表中
        * 然后对字符串进行遍历，由于组合只有两种，一种是 1 个字符，一种是 2 个字符，其中 2 个字符优先于 1 个字符
        * 先判断两个字符的组合在哈希表中是否存在，存在则将值取出加到结果 ans 中，并向后移2个字符。不存在则将判断当前 1 个字符是否存在，存在则将值取出加到结果 ans 中，并向后移 1 个字符
        * 遍历结束返回结果 ans
        */
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Illegal character");
        }
    }

    public static int method2(String s) {
        // method 2
        /*
         * 方法二就是判断后一个数比前一个数大的时候，就减去当前这个数的值，即把当前这个数当成负数
         * 另外方法二用的内存比方法一小很多，原因是方法二没用使用HashMap存储
         */
        int result = 0, i = 0, n = s.length();
        while (i < n) {
            int current = getValue(s.charAt(i));
            if (i == n - 1 || current >= getValue(s.charAt(i + 1))) {
                result += current;
            } else {
                result -= current;
            }
            i++;
        }
        return result;
    }
//leetcode submit region end(Prohibit modification and deletion)

}