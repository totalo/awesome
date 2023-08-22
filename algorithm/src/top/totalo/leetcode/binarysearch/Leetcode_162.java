package top.totalo.leetcode.binarysearch;

/**
 * 
 * <a href="https://leetcode.cn/problems/find-peak-element/">162. 寻找峰值</a>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class Leetcode_162 {
    
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            // 若二分的位置 大于上一个数，说明该数在峰值的右侧 或者就是峰值，否则在峰值的左侧
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1})); // 2
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4})); // 1 or 5
    }
}
