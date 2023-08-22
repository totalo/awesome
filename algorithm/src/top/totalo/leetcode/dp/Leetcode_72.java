package top.totalo.leetcode.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/description/">72. 编辑距离</a>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Leetcode_72 {
    
    int[][] memo;
    
    String s1;
    String s2;
    public int minDistance(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        memo = new int[n][m];
        s1 = text1;
        s2 = text2;
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, m - 1);
    }
    
    private int dfs(int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = dfs(i - 1, j - 1);
        }
        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
    }
}
