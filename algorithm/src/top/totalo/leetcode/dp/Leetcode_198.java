package top.totalo.leetcode.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">198. 打家劫舍</a>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 */
public class Leetcode_198 {
    
    private static int[] memo;
    private static int[] numsx;
    
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, - 1);
        numsx = nums;
        return dfs(nums.length - 1);
        
    }
    
    // 时间：O(n)
    // 空间：O(n)
    public static int rob_2(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[nums.length + 1];
    }
    
    // 时间：O(n)
    // 空间：O(1)
    public static int rob_3(int[] nums) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
            int f2 = Math.max(f1, f0 + num);
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }
    
    private static int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = Math.max(dfs(i - 1), dfs(i - 2) + numsx[i]);
        memo[i] = res;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1})); // 4
        System.out.println(rob_2(new int[]{1,2,3,1}));
        System.out.println(rob_3(new int[]{1,2,3,1}));
    }
}
