package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">77. 组合</a>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class Leetcode_77 {
    
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    int k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        path = new ArrayList<>();
        dfs(n);
        return ans;
    }
    
    private void dfs(int i) {
        int d = k - path.size();
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; --j) {
            path.add(j);
            dfs(j - 1);
            path.remove(path.size() - 1);
        }
    }
}
