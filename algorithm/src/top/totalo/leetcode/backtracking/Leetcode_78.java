package top.totalo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 * <p> 
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 
 * 子集型回溯，写法1
 */
public class Leetcode_78 {
    
    private int[] nums;
    
    private List<Integer> path = new ArrayList<>();
    
    private List<List<Integer>> res = new ArrayList<>();
    
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return res;
    }
    
    private void dfs(int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(i + 1);
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1);
    }
    
    public static void main(String[] args) {
        Leetcode_78 leetcode_78 = new Leetcode_78();
        System.out.println(leetcode_78.subsets(new int[]{1, 2, 3}));
    }
}
