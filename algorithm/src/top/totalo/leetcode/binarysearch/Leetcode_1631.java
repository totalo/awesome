package top.totalo.leetcode.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
 * 
 * 一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 */
public class Leetcode_1631 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [[1,2,2],[3,8,2],[5,3,5]]
        System.out.println(solution.minimumEffortPath(new int[][]{{1,2,2}, {3,8,2}, {5,3,5}})); // 2
        // [1,2,3],[3,8,4],[5,3,5]
        System.out.println(solution.minimumEffortPath(new int[][]{{1,2,3}, {3,8,4}, {5,3,5}})); // 1
        // [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
        System.out.println(solution.minimumEffortPath(new int[][]{{1,2,1,1,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,1,1,2,1}})); // 0
        
    }
    
    static class Solution {
        
        private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            int l = 0, r = 999999, ans = 0;
            while (l <= r) {
                int mid = (r + l) / 2;
                Queue<int[]> queue = new LinkedList<int[]>();
                queue.offer(new int[]{0, 0});
                boolean[] seen = new boolean[m * n];
                seen[0] = true;
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int x = cell[0], y = cell[1];
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dir[i][0];
                        int ny = y + dir[i][1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                            queue.offer(new int[]{nx, ny});
                            seen[nx * n + ny] = true;
                        }
                    }
                }
                if (seen[m * n - 1]) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return ans;
        }
    }
}
