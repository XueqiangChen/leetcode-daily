package leetcode.editor.datastructure;

import lombok.Data;

@Data
public class ListNode {

    private int val;
    private ListNode next;

    ListNode(int x) {
        val = x;
    }
}
