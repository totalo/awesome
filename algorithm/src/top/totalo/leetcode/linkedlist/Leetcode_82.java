package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/">82. 删除排序链表中的重复元素 II</a>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class Leetcode_82 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode deleteDuplicates(ListNode head) {
        // 可能头节点需要删除，所以需要哨兵节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        // 循环到下一个节点为空或者下下个节点为空时
        while (cur.next != null && cur.next.next != null) {
            // 如果下一个指针的值和下下个节点的值相等
            if (cur.next.next.val == cur.next.val) {
                int val = cur.next.val;
                // 循环删除
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5})).output()); // 1, 2, 5
        System.out.println(deleteDuplicates(new ListNode(new int[]{1,1,1,2,3})).output()); // 2, 3
    }
}
