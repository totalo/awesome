package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">92. 反转链表 II</a>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 
 */
public class Leetcode_92 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 声明哨兵节点，方式left=1时，没有头节点的问题
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        int k = 1;
        // 移动到需要反转链表的前一个节点
        while (k <= left - 1) {
            p0 = p0.next;
            k++;
        }
        // 区间内反转
        ListNode pre = null, cur = p0.next;
        k = 1;
        while (k <= right - left + 1) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k++;
        }
        // 根据性质头节点需要对接反转前的尾节点，反转前的反转位置需要对接反转前的反转区间以外右边的第一个节点
        // 链表反转后 pre 指向反转前的尾节点，cur指向反转切的尾节点后一个节点
        // 变更反转前的第一个节点指向反正后区间外的第一个节点
        p0.next.next = cur;
        // 变更头节点下一个为未反转前区间内的最后一个节点
        p0.next = pre;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(reverseBetween(node, 2, 4).output()); // 1,4,3,2,5
    }
}
