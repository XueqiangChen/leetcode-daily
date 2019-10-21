package leetcode.editor.en;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
//        System.out.println(solution.isValid("()[]{}"));
//        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("([)]"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            // 如果字符串的长度是奇数的话就无法匹配
            if (s.length() != 0 && s.length() % 2 != 0) {
                return false;
            }

            Map<String, String> map = new HashMap<>();
            map.put("(", ")");
            map.put("[", "]");
            map.put("{", "}");

            char[] chars = s.toCharArray();
            ArrayList<String> arrayList = new ArrayList<>();
            for (char c : chars) {
                arrayList.add(String.valueOf(c));
            }

            Stack<String> stack = new Stack<>();
            for (String str : arrayList) {
                if (!stack.isEmpty()) {
                    if (map.get(stack.peek()) == null) {
                        return false;
                    } else if (map.get(stack.peek()).equals(str)) {
                        stack.pop();
                        continue;
                    }
                }

                stack.push(str);//]
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}