package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第 N 个结点</a>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p> 
 * 双指针
 */
public class Leetcode_19 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode right = dummy, left = dummy;
        while (n-- > 0) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(removeNthFromEnd(node, 2).output()); // 1,2,3,5
        
        ListNode node2 = new ListNode(new int[]{1});
        System.out.println(removeNthFromEnd(node2, 1)); // []
        
        ListNode node3 = new ListNode(new int[]{1, 2});
        System.out.println(removeNthFromEnd(node3, 1).output()); // 1
    }
}
