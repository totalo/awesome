package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/description/">22.括号生成</a>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Leetcode_22 {
    
    private int n;
    
    private List<String> ans;
    
    private char[] path;
    
    // 时间复杂度：O(n * C(2n, n))，实际没有遍历这么多次，可以了解一下卡特兰数
    // 空间复杂度：O(n)
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        this.path = new char[2 * n];
        dfs(0, 0);
        return ans;
    }
    
    /**
     * 深度搜索
     * @param i 当前的位置
     * @param open 左括号的数量
     */
    private void dfs(int i, int open) {
        // 若已经满足条件，直接添加
        if (i == 2 * n) {
            ans.add(new String(path));
            return;
        }
        // 若当前左括号的数少于 n, 可以继续选择左括号
        if (open < n) {
            path[i] = '(';
            dfs(i + 1, open + 1);
        }
        // 右括号的数一定要小于等于左括号数，小于则可以继续选择
        if (i - open < open) {
            path[i] = ')';
            dfs(i + 1, open);
        }
    }
    
    public static void main(String[] args) {
        Leetcode_22 leetcode22 = new Leetcode_22();
        System.out.println(leetcode22.generateParenthesis(3));
    }
}
