package top.totalo.common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {
    }
    
    public ListNode(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
    }
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
    
    public String output() {
        StringBuilder sb = new StringBuilder("[" + this.val);
        ListNode cur = next;
        while (cur != null) {
            sb.append(",").append(cur.val);
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
