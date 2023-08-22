package top.totalo.leetcode.linkedlist;

import top.totalo.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">142. 环形链表 II</a>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * 
 * 快慢指针
 * 如下：
 * 环长为:b + c
 * slow移动的距离：a + b
 * fast移动的距离：a + b + k(b + c)
 * 而快指正一定的距离是慢指针的2倍：2(a+b) = a + b + k(b + c)
 * 优化一下：a - c = (k - 1)(b + c)
 * 由此可以得出，slow在与fast相遇后，走c步后到达环的入口，而head走c步后的距离入口的距离刚刚好是环长度的倍数，则二者的相遇点一定是入口
 */
public class Leetcode_142 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // 快慢指针验证有没有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果存在相等的情况，说明有环
            if (slow == fast) {
                // 根据分析的性质，此时，slow再c步到达环的入口，而head走c步后距离入口的距离刚刚好手环的倍数，接着循环，二者相遇时，一定是入口
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
