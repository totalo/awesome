package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/permutations/description/">46. 全排列</a>
 * <p> 
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Leetcode_46 {
    
    private int[] nums;
    
    private boolean[] onPath;
    
    private int[] path;
    
    private List<List<Integer>> ans;
    
    // 时间复杂度：O(n * n!)
    // 
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.onPath = new boolean[nums.length];
        this.path = new int[nums.length];
        this.ans = new ArrayList<>();
        dfs(0);
        return ans;
    }
    
    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(Arrays.stream(path).boxed().collect(Collectors.toList()));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (onPath[j]) {
                continue;
            }
            path[i] = nums[j];
            onPath[j] = true;
            dfs(i + 1);
            onPath[j] = false;
        }
    }
    
    public static void main(String[] args) {
        Leetcode_46 leetcode46 = new Leetcode_46();
        System.out.println(leetcode46.permute(new int[]{1,2,3}));
    }
}
