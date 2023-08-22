package top.totalo.leetcode.dp;

import java.util.Arrays;

public class Leetcode_1039 {
    
    private int[] nums;
    
    private int[][] memo;
    
    // 时间复杂度：o(n^3)
    // 空间复杂度：o(n)
    public int minScoreTriangulation(int[] values) {
        this.nums = values;
        this.memo = new int[values.length][values.length];
        for (int i = 0; i < values.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, values.length - 1);
    }
    
    private int dfs(int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k) + dfs(k, j ) + nums[i] * nums[j] * nums[k]);
        }
        return memo[i][j] = res;
    }
    
    public static void main(String[] args) {
        Leetcode_1039 leetcode_1039 = new Leetcode_1039();
        System.out.println(leetcode_1039.minScoreTriangulation(new int[]{1, 2, 3}));
    }
}
