package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">25. K 个一组翻转链表</a>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class leetcode_25 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        // 计算数组长度
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy, pre = null;
        cur = p0.next;
        // 每次统计一下是否够k个一组，不够直接不转换
        while (len >= k) {
            len -= k;
            int x = k;
            while (x > 0) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                x--;
            }
            // 暂存一下p0
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            // 移动p0至下一个位置
            p0 = nxt;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(reverseKGroup(head, 2).output()); // 2,1,4,3,5
        head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(reverseKGroup(head, 3).output());  // 3,2,1,4,5
    }
}
