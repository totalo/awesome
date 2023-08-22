package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206. 反转链表</a>
 */
public class Leetcode_206 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            // 暂存下一个节点
            ListNode next = cur.next;
            // 当前指针的下一个节点指向上一个
            cur.next = pre;
            // 移动上一个节点至当前节点
            pre = cur;
            // 当前节点移动到下一个节点
            cur = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        System.out.println(reverseList(new ListNode(new int[]{1,2,3,4,5})).output());
    }
}
