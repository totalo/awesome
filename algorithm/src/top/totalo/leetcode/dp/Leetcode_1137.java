package top.totalo.leetcode.dp;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class Leetcode_1137 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(4)); // 4
        System.out.println(solution.tribonacci(25)); // 1389537
    }
    
    /**
     * 思路：按照题目定义递推即可
     * 时间：O（n）
     * 空间：O（1）
     */
    static class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n <= 2) {
                return 1;
            }
            int p = 0, q = 1, r = 1, s = 0;
            for (int i = 3; i<= n; i++) {
                s = p + q + r;
                p = q;
                q = r;
                r = s;
            }
            return s;
        }
    }
}
