package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">876. 链表的中间结点</a>
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p> 
 * 快慢指针
 */
public class Leetcode_876 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        System.out.println(middleNode(new ListNode(new int[]{1,2,3,4,5})).output()); // 3,4,5
        System.out.println(middleNode(new ListNode(new int[]{1,2,3,4,5,6})).output()); // 4,5,6
    }
}
