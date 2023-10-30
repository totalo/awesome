package top.totalo.sort;

import java.util.Arrays;

/**
 * 快拍
 */
public class QuickSort implements Sort {
    
    @Override
    public int[] sort(final int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        quickSort(arrCopy, 0, arrCopy.length - 1);
        return arrCopy;
    }
    
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // int pivot = doublePointerSwap(arr, left, right);
        int pivot = doublePointerHole(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
        
    }
    
    /**
     * 双指针交换
     * @param arr 排序区间
     * @param start 开始位置
     * @param end 结束位置
     * @return 交换后的基准位置
     */
    private int doublePointerSwap(int[] arr, int start, int end) {
        // 以第一个数为基准
        int privot = arr[start], left = start, right = end;
        while (left < right) {
            // 从右往左找到第一个小于基准的数
            while (left < right && arr[right] > privot) {
                right--;
            }
            
            // 从左往右找到第一个大于基准的数
            while (left < right && arr[left] <= privot) {
                left++;
            }
            
            // 交换两个数在数组中的位置
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        
        // 当前指针数据 与 基准数据交换
        arr[start] = arr[right];
        arr[right] = privot;
        // 返回基准数据的位置
        return right;
    }
    
    /**
     * 双指针挖坑
     * @param arr 排序区间
     * @param start 开始位置
     * @param end 结束位置
     * @return 交换后的基准位置
     */
    private int doublePointerHole(int[] arr, int start, int end) {
        int privot = arr[start], left = start, right = end;
        while (left < right) {
            // 从右往左找到第一个小于基准的数
            while (left < right && arr[right] > privot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            // 从左往右找到第一个大于基准的数
            while (left < right && arr[left] <= privot) {
                left++;
            }
            // 交换两个数在数组中的位置
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[right] = privot;
        return right;
    }
    
    /**
     * 单指针
     * @param arr 排序区间
     * @param start 开始位置
     * @param end 结束位置
     * @return 交换后的基准位置
     */
    private int singlePointer(int[] arr, int start, int end) {
        int privot = arr[start], mark = start;
        for (int i = start + 1; i <= end; i++) {
            // 若比分界值小，则mark++，并交换位置
            if (arr[i] < privot) {
                mark++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        // 将分界值与mark所在位置的值交换
        arr[start] = arr[mark];
        arr[mark] = privot;
        return mark;
    }
}
