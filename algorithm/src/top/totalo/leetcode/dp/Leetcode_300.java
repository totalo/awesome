package top.totalo.leetcode.dp;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Leetcode_300 {
    
    private int[] memo;
    private int[] nums;
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        memo = new int[len];
        this.nums = nums;
        //Arrays.fill(memo, -1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }
    
    private int dfs(int i) {
        if (memo[i] != 0) {
            return memo[i];
        }
        int res = 0;
        for (int j = i; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(j));
            }
        }
        return res + 1;
    }
}
