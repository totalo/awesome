package top.totalo.leetcode.dp;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class Leetcode_509 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(2)); // 1
        System.out.println(solution.fib(3)); // 2
        System.out.println(solution.fib(4)); // 3
    }
    
    /**
     * 思路：根据题目意思去实现即可
     * 时间：O（n）
     * 空间：O（1）
     */
    static class Solution {
        public int fib(int n) {
            if(n <= 1) {
                return n;
            }
            int p = 0, q = 1, r = 1;
            for (int i = 2; i <= n; i++) {
                r = p + q;
                p = q;
                q = r;
            }
            return r;
        }
    }
}
