package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">131. 分割回文串</a>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 子集型回溯写法2
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">131. 分割回文串</a>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串
 */
public class Leetcode_131 {
    
    private String s;
    
    private List<String> path = new ArrayList<>();
    
    private List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return res;
    }
    
    private void dfs(int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String subString = s.substring(i, j + 1);
            if (subString.contentEquals(new StringBuilder(subString).reverse())) {
                path.add(subString);
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
            
        }
    }
}
