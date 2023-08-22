package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">17. 电话号码的字母组合</a>
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Leetcode_17 {
    
    static String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};
    
    private static List<String> ans = new ArrayList<>();
    
    private static char[] digit, path;
    
    // 时间复杂度：O(n4^n)
    // 空间复杂度：O(n)
    public static List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) {
            return ans;
        }
        path = new char[len];
        digit = digits.toCharArray();
        dfs(0);
        return ans;
    }
    
    private static void dfs(int i) {
        if (i == digit.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digit[i] - '0'].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
