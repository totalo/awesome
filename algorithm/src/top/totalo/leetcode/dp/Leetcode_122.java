package top.totalo.leetcode.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">122. 买卖股票的最佳时机 II</a>
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 *
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309. 最佳买卖股票时机含冷冻期</a>
 * <p>
 * 同理，但是要卖股票后要变成i - 2
 * <p>
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">188. 买卖股票的最佳时机 IV</a>
 * <p> 
 * 同理，加一个参数统计交易次数，最多卖出k次，最多买入k次，由于最后的股票清零，买了k则必然卖了k，由此计算一个地方就行
 */
public class Leetcode_122 {
    
    private int[] prices;
    
    private int[][] memo;
    
    // 时间复杂度：o(n)
    // 空间复杂度：o(n)
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(prices.length - 1, 0);
    }
    
    private int dfs(int i, int hold) {
        if (i < 0) {
            return hold == 1 ? Integer.MIN_VALUE : 0;
        }
        if (memo[i][hold] != -1) {
            return memo[i][hold];
        }
        if (hold == 1) {
            return memo[i][hold] = Math.max(dfs(i - 1, 1), dfs(i - 1, 0) - prices[i]);
        }
        return memo[i][hold] = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + prices[i]);
    }
}
