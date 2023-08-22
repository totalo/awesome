package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">141. 环形链表</a>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 
 * 快慢指针，如果存在环，则快指针和慢指针一定会相遇
 */
public class Leetcode_141 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // 依赖于测评系统的标识，无法构造环或者后续实现构造环
        ListNode node = new ListNode(new int[]{3,2,0,-4});
        System.out.println(hasCycle(node));
    }
}
