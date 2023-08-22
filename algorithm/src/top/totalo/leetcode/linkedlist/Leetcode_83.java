package top.totalo.leetcode.linkedlist;


import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Leetcode_83 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(new int[]{1,1,2})).output()); // [1,2]
        System.out.println(deleteDuplicates(new ListNode(new int[]{1,1,2,3,3})).output()); // [1, 2, 3]
    }
}
