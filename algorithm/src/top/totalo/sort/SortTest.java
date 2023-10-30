package top.totalo.sort;

public class SortTest {
    
    public static void main(String[] args) {
        Sort sort = null;
        int[] arr = { 1, 3, 2, 5, 4 };
        System.out.print("冒泡排序：");
        sort = new BubbleSort();
        for (int i : sort.sort(arr)) {
            System.out.print(i + "-");
        }
        System.out.println();
        
        System.out.print("选择排序：");
        sort = new SelectSort();
        for (int i : sort.sort(arr)) {
            System.out.print(i + "-");
        }
        System.out.println();
        
        System.out.print("插入排序：");
        sort = new InsertSort();
        for (int i : sort.sort(arr)) {
            System.out.print(i + "-");
        }
        System.out.println();
        
        System.out.print("希尔排序：");
        sort = new ShellSort();
        for (int i : sort.sort(arr)) {
            System.out.print(i + "-");
        }
        System.out.println();
        
        System.out.print("快速排序：");
        sort = new QuickSort();
        for (int i : sort.sort(arr)) {
            System.out.print(i + "-");
        }
        System.out.println();
    }
}
