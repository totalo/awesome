package top.totalo.leetcode.dp;

/**
 * <a href="https://leetcode.cn/problems/target-sum/">494. 目标和</a>
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class Leetcode_494 {
    
    private static int[] numsx;
    
    /**
     * 0 - 1 背包问题的转换
     * 
     * 假设所有添加 `+` 的和为 p, 所有数的和为 s
     * 则添加 `-` 数的和为  s - p
     * 要满足题目条件，即 ： p - (s - p) = target;
     * 进而 p = (s + target) / 2;
     * 得出结论：s + target 不能为 0 且要为偶数。按照 p - (s - p) 进行递归即可。
     * @param nums 原数组
     * @param target 目标值
     * @return 方案
     */
    public static int findTargetSumWays(int[] nums, int target) {
        numsx = nums;
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 != 0) {
            return 0;
        }
        target /= 2;
        int len = nums.length;
        return dfs(len - 1, target);
    }
    
    private static int dfs(int i, int c) {
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }
        if (c < numsx[i]) {
            return dfs(i - 1, c);
        }
        return dfs(i - 1, c) + dfs(i - 1, c - numsx[i]);
    }
    
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3)); // 5
    }
}
