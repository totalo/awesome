package top.totalo.leetcode.dp;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class Leetcode_746 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10,15,20})); // 15
        System.out.println(solution.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1})); // 6
    }
    
    static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            if (cost.length < 2) {
                return cost[0];
            }
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[cost.length];
        }
    }
    
}
