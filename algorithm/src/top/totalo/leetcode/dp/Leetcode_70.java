package top.totalo.leetcode.dp;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Leetcode_70 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2)); // 2
        System.out.println(solution.climbStairs(3)); // 3
    }
    
    static class Solution {
        /**
         * 思路：f(x) = f(x - 1) + f(x - 2) 爬到第x级台阶可由x - 1 级台阶到达 也可以由 f(x - 2)级台阶到达
         * 时间复杂度：O(n)
         * 空间：O（n）
         * @param n 楼梯数
         * @return
         */
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            if (n <= 2) {
                return n;
            }
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
