// 2-两数相加

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5962 👎 0


package leetcode.editor.cn;

//https://blog.csdn.net/zyx_ly/article/details/104319295
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // [2,4,3]
        // [5,6,4]

        // [9]
        // [1,9,9,9,9,9,9,9,9,9]
        int[] a1 = new int[]{9};
        ListNode l1 = ListNode.createLinkedList(a1);
        int[] a2 = new int[]{1,9,9,9,9,9,9,9,9,9};
        ListNode l2 = ListNode.createLinkedList(a2);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null || l2 == null) {
                return null;
            }

            // 将链表的整数还原
            long num1 = 0, num2 = 0, count = 0;
            ListNode temp1 = l1;
            while(temp1 != null) {
                num1 += temp1.val * Math.pow(10, count);
                count++;
                temp1 = temp1.next;
            }

            count = 0;
            ListNode temp2 = l2;
            while(temp2 != null) {
                num2 += temp2.val * Math.pow(10, count);
                count++;
                temp2 = temp2.next;
            }

            // 将结果逆序输出
            long result = num1 + num2;
            long last = result % 10;
            ListNode res = new ListNode((int) last);
            ListNode current = res;
            result = result / 10;
            while(result > 0) {
                last = result % 10;
                current.next = new ListNode((int) last);
                current = current.next;
                result = result / 10;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}