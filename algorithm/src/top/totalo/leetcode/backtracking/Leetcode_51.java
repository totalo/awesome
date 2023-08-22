package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens/description/">51. N 皇后</a>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Leetcode_51 {
    private int n;
    private int[] col;
    private boolean[] onPath, diag1, diag2;
    private final List<List<String>> ans = new ArrayList<>();
    
    // 时间复杂度：O（n * n!）
    // 空间复杂度：O（n）
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new int[n];
        onPath = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];
        dfs(0);
        return ans;
    }
    
    private void dfs(int r) {
        if (r == n) {
            List<String> board = new ArrayList<>(n);
            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        for (int c = 0; c < n; ++c) {
            // 左上 行 - 列 为规定值，右上 行 + 列 为规定值，此处可能为负数，加上 n - 1;
            int rc = r - c + n - 1;
            // 这个位置没放过皇后，且不在同一条对角线上
            if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                col[r] = c;
                onPath[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1);
                onPath[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
            }
        }
    }
}
