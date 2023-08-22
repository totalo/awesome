package top.totalo.leetcode.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/description/">1143. 最长公共子序列</a>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class Leetcode_1143 {
    
    int[][] memo;
    
    String s1;
    String s2;
    public int longestCommonSubsequence(String text1, String text2) {
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
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = dfs(i - 1, j - 1) + 1;
        }
        return memo[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
    
    public static void main(String[] args) {
        
    }
    
}
