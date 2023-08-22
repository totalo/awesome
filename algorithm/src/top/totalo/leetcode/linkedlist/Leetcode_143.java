package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reorder-list/description/">143. 重排链表</a>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  根据规律，后半段是从下往大，由此可以进行链表的反转，再根据规律，实现要求
 */
public class Leetcode_143 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reversList(mid);
        while (head2.next != null) {
            ListNode next = head.next;
            ListNode next2 = head2.next;
            head.next = head2;
            head2.next = next;
            head = next;
            head2 = next2;
        }
    }
    
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private static ListNode reversList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1,2,3,4});
        reorderList(node);
        System.out.println(node.output()); // 1,4,2,3
        
        ListNode node2 = new ListNode(new int[]{1,2,3,4,5});
        reorderList(node2);
        System.out.println(node2.output()); // 1,5,2,4,3
    }
}
