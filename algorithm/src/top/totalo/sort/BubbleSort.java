package top.totalo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * 思路：每次从头开始，两两比较，将最大的放到最后，下次比较时，不再比较最后一个
 * 参考：<a href="https://www.runoob.com/w3cnote/bubble-sort.html">冒泡排序</a>
 */
public class BubbleSort implements Sort {
    
    @Override
    public int[] sort(final int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        // 需要循环 n - 1 次
        for (int i = 0; i < arrCopy.length - 1; i++) {
            boolean noSwap = true;
            // 这里的 - 1 - i 是因为后面的已经排好序了
            for (int j = 0; j < arrCopy.length - 1 - i; j++) {
                // 相邻的两两比较，进行交换
                if (arrCopy[j] > arrCopy[j + 1]) {
                    int tmp = arrCopy[j];
                    arrCopy[j] = arrCopy[j + 1];
                    arrCopy[j + 1] = tmp;
                    noSwap = false;
                }
            }
            // 上一轮未发生互换，说明有序
            if (noSwap) {
                break;
            }
        }
        return arrCopy;
    }
}
