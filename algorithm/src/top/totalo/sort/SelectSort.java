package top.totalo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 思路：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *      重复第二步，直到所有元素均排序完毕。
 * 参考：<a href="https://www.runoob.com/w3cnote/selection-sort.html">选择排序</a>
 */
public class SelectSort implements Sort {
    
    @Override
    public int[] sort(final int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        // 循环 n 次
        for (int i = 0; i < arrCopy.length; i++) {
            int minIndex = i;
            // 从 i 下标开始，找到最小的数，与当前的 i 互换
            for (int j = i + 1; j < arrCopy.length; j++) {
                if (arrCopy[j] < arrCopy[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = arrCopy[i];
                arrCopy[i] = arrCopy[minIndex];
                arrCopy[minIndex] = tmp;
            }
        }
        return arrCopy;
    }
}
