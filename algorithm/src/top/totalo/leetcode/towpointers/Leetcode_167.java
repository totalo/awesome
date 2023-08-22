package top.totalo.leetcode.towpointers;

import java.util.Arrays;

/**
 * 双向指针
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 */
public class Leetcode_167 {
    
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6))); // [1,3]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1))); // [1,2]
    }
}
