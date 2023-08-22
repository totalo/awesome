package top.totalo.leetcode.dp;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的
 * 
 * 完全背包问题
 */
public class Leetcode_322 {
    
    private int[][] memo;
    
    private int[] coins;
    
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.memo = new int[coins.length][amount + 1];
        int ans = dfs(coins.length - 1, amount);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
    
    private int dfs(int i, int c) {
        if (i < 0) {
            return c == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        if (memo[i][c] != 0) {
            return memo[i][c];
        }
        if (c < coins[i]) {
            return memo[i][c] = dfs(i - 1, c);
        }
        int res = Math.min(dfs(i - 1, c), dfs(i, c - coins[i]) + 1);
        memo[i][c] = res;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Leetcode_322().coinChange(new int[]{1, 2, 5}, 11)); // 3
    }
}
