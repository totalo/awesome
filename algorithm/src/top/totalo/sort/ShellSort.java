package top.totalo.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 思路：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 * 参考：<a href="https://www.runoob.com/w3cnote/shell-sort.html">希尔排序</a>
 */
public class ShellSort implements Sort {
    
    @Override
    public int[] sort(final int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int length = arrCopy.length;
        int tmp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                tmp = arrCopy[i];
                int j = i - step;
                while (j > 0 && arrCopy[j] > tmp) {
                    arrCopy[j + step] = arrCopy[j];
                    j -= step;
                }
                arrCopy[j + step] = tmp;
            }
        }
        return arrCopy;
    }
}
