package top.totalo.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 *
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 *
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 *
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 *
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 */
public class Leetcode_1235 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70})); // 120
        System.out.println(solution.jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60})); // 150
        System.out.println(solution.jobScheduling(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4})); // 6
    }
    
    static class Solution {
        public int jobScheduling(int[] st, int[] et, int[] ps) {
            int n = st.length;
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(new int[]{st[i], et[i], ps[i]});
            // 按照结束时间排序
            list.sort((a, b) -> a[1] - b[1]);
            int[] f = new int[n + 10];
            for (int i = 1; i <= n; i++) {
                int[] info = list.get(i - 1);
                int a = info[0], b = info[1], c = info[2];
                f[i] = Math.max(f[i - 1], c);
                int l = 0, r = i - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (list.get(mid)[1] <= a) l = mid;
                    else r = mid - 1;
                }
                if (list.get(r)[1] <= a) f[i] = Math.max(f[i], f[r + 1] + c);
            }
            return f[n];
        }
    }
}
