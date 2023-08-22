package top.totalo.leetcode.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/description/">516. 最长回文子序列</a>
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p> 
 * 区间dp
 */
public class Leetcode_516 {
    
    private String s;
    
    private int[][] memo;
    
    public int longestPalindromeSubseq(String s) {
        this.s = s;
        int len = s.length();
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, len - 1);
    }
    
    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = dfs(i + 1, j - 1) + 2;
        }
        return memo[i][j] = Math.max(dfs(i + 1, j), dfs(i, j - 1));
    }
}
