package leetcode.editor.cn;

// 2021-01-12 09:31:56-141

//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 903 👎 0


public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();

        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        boolean ret = solution.hasCycle(n1);
        System.out.println(ret);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 边界情况，节点为空或者只有一个节点的时候，不存在环
            if (head == null || head.next == null) {
                return false;
            }

            // 程序框架
            // 1. 定义两个指针，ptr1 每次向前走 1 步，ptr2 每次向前走 2 步
            ListNode ptr1 = head, ptr2 = head;
            while (ptr2 != null && ptr2.next != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next.next;
                // 2. 当 ptr2 <= ptr1 的时候，说明有环存在
                if (ptr1 == ptr2) {
                    return true;
                }
            }

            // 3. 当 ptr2 为 null 或者 ptr2 是最后一个节点的时候，说明已经遍历完整个链表，链表没有环
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}