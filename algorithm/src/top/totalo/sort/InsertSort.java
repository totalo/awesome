package top.totalo.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * 思路：依次遍历，然后找到当前下标的数字在前面排好的有序序列的位置
 * 参加：<a href="https://www.runoob.com/w3cnote/insertion-sort.html">插入排序</a>
 */
public class InsertSort implements Sort {
    @Override
    public int[] sort(final int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arrCopy.length; i++) {
            // 判断当前的 i 下标的值应该放那个位置
            int tmp = arrCopy[i], j = i;
            // 从后往前找，找到对应的位置
            // 若当前的数都小于需要排序的数，则一个一个往后移动
            while (j > 0 && tmp < arrCopy[j - 1]) {
                arrCopy[j] = arrCopy[j - 1];
                j--;
            }
            if (i != j) {
                arrCopy[j] = tmp;
            }
        }
        return arrCopy;
    }
}
