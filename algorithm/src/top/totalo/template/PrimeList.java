package top.totalo.template;

import java.util.Arrays;

/**
 * 筛法求质数
 */
public class PrimeList {
    
    // 主要思想就是：标记某一个数以及其倍数
    // 
    public static int[] getPrimes(int max) {
        int[] ans = new int[max + 1];
        ans[0] = 0;
        int idx = 1;
        boolean[] isPrimes = new boolean[max];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i < max; i++) {
            if (isPrimes[i]) {
                ans[idx++] = i;
                for (int j = i * i; j < max; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPrimes(10)));
    }
}
