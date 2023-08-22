package top.totalo.leetcode.towpointers;

/**
 * 同向双指正，滑动窗口
 * <a href="https://leetcode.cn/problems/subarray-product-less-than-k/">713. 乘积小于 K 的子数组</a>
 */
public class Leetcode_713 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, ans = 0, prod = 1, right = 0;
        // 枚举右端点
        while (right < nums.length) {
            // 将右端点纳入积中
            prod *= nums[right];
            // 如果当前的乘积是否大于k，大于则移动左端点
            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }
            // 因为右端点是固定的，所以
            // [l, r], [l + 1, r] ... [r, r] 都是满足条件的
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100)); // 8
        System.out.println(numSubarrayProductLessThanK(new int[]{1,2,3}, 0)); // 0
    }
}
