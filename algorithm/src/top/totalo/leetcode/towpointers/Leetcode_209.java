package top.totalo.leetcode.towpointers;


/**
 * 同向，双指针，
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 */
public class Leetcode_209 {
    
    // 时间复杂度：O（n），最多加到n
    // 空间复杂度：O（1）
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, left = 0, right = 0;
        int sum = 0;
        // 枚举右端点
        while (right < nums.length) {
            // 将右端点加入和
            sum += nums[right];
            // 若添加右端点，超过target
            while (sum >= target) {
                // 更新结果
                ans = Math.min(ans, right - left + 1);
                // 将左端点移除，并移动左端点
                sum -= nums[left];
                // 重复此过程
                left++;
            }
            // 接着枚举右端点
            right++;
        }
        return ans <= nums.length ? ans : 0;
    }
    
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4})); // 1
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
    }
}
