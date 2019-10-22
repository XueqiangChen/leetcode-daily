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

            Stack<String> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                String str = String.valueOf(c);
                if (!stack.isEmpty()) {
                    if (map.get(stack.peek()) == null) { // 左边是 ")", "]", "}"的情况
                        return false;
                    } else if (map.get(stack.peek()).equals(str)) { // 括号映射关系匹配
                        stack.pop();
                        continue;
                    }
                }

                stack.push(str);
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * // 官方答案：栈
     *
     * class Solution {
     *
     *   // Hash table that takes care of the mappings.
     *   private HashMap<Character, Character> mappings;
     *
     *   // Initialize hash map with mappings. This simply makes the code easier to read.
     *   public Solution() {
     *     this.mappings = new HashMap<Character, Character>();
     *     this.mappings.put(')', '(');
     *     this.mappings.put('}', '{');
     *     this.mappings.put(']', '[');
     *   }
     *
     *   public boolean isValid(String s) {
     *
     *     // Initialize a stack to be used in the algorithm.
     *     Stack<Character> stack = new Stack<Character>();
     *
     *     for (int i = 0; i < s.length(); i++) {
     *       char c = s.charAt(i);
     *
     *       // If the current character is a closing bracket.
     *       if (this.mappings.containsKey(c)) {
     *
     *         // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
     *         char topElement = stack.empty() ? '#' : stack.pop();
     *
     *         // If the mapping for this bracket doesn't match the stack's top element, return false.
     *         if (topElement != this.mappings.get(c)) {
     *           return false;
     *         }
     *       } else {
     *         // If it was an opening bracket, push to the stack.
     *         stack.push(c);
     *       }
     *     }
     *
     *     // If the stack still contains elements, then it is an invalid expression.
     *     return stack.isEmpty();
     *   }
     * }
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
     */
}