package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/">216. 组合总和 III</a>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回
 */
public class Leetcode_216 {
    
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    int k;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        path = new ArrayList<>();
        dfs(9, n);
        return ans;
    }
    
    private void dfs(int i, int t) {
        int d = k - path.size();
        if (t < 0 || t > (i * 2 - d + 1) * d / 2) {
            return;
        }
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; --j) {
            path.add(j);
            dfs(j - 1, t - j);
            path.remove(path.size() - 1);
        }
    }
}
