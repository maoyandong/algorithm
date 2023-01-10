package sort;

import java.util.Arrays;

/**
 * @author: MaoYanDong
 * @create: 2023-01-04 16:46
 * @Version 1.0
 * @description: 排序算法主程序入口
 */
/**
 * 归并排序和快速排序都用到了分治思想，非常巧妙。我们可以借鉴这个思想，来解决非排序的问题，
 * 比如：如何在 O(n) 的时间复杂度内查找一个无序数组中的第 K 大元素？
 * 分治法的基本思想：将一个难以直接解决的大问题，分割成一些规模较小的相同问题，以便各个击破，分而治之。
 */
public class Main {
    public static void main(String[] args) {
        int [] a = {4,5,6,3,2,1};
        bubbleSort(a, a.length);
        System.out.println(Arrays.toString(a));
        int [] b = {6,5,4,1,3,2};
        insertionSort(b, b.length);
        System.out.println(Arrays.toString(b));
        int [] c = {6,4,5,1,3,2};
        selectionSort(c, c.length);
        System.out.println(Arrays.toString(c));
        int [] d = {6,2,1,3,5,4};
        mergeSort(d, d.length);
        System.out.println(Arrays.toString(d));
        int [] e = {6,5,4,1,3,2};
        quicksort(e, e.length);
        System.out.println(Arrays.toString(e));
    }

    /**
     * 冒泡排序 稳定排序算法
     * @param a 数组
     * @param n 数组大小
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 表示没有发生交换，可以直接退出
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 插入排序 稳定排序算法
     * @param a 数组
     * @param n 数组大小
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // i标识目前要插入的元素
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 元素后移
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }

    /**
     * 选择排序 不稳定
     * @param a 数组
     * @param n 数组大小
     */
    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            // 记录最小值的位置
            int min = i;
            int j = i + 1;
            for (; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            // 交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * 归并排序 稳定
     * @param a 数组
     * @param n 数组大小
     */
    public static void mergeSort(int[] a, int n) {
        merge_sort_c(a, 0, n-1);
    }

    /**
     * 递归算法
     * @param a 原数组
     * @param p 数组起点
     * @param r 数组终点
     */
    private static void merge_sort_c(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        // 中间位置
        int m = (p + r) / 2;
        merge_sort_c(a, p, m);
        merge_sort_c(a, m+1, r);
        merge(a, p, m, r);
    }

    /**
     * 合并两个排好序的数组到原数组
     * @param a 原数组
     * @param p 归并起点
     * @param m 归并数组分界点
     * @param q 归并终点
     */
    private static void merge(int[] a, int p, int m, int q) {
        // 存放归并后的数据
        int[] s = new int[q - p + 1];
        int t = m + 1;
        int k = 0;
        // 定义两个变量保存初始值
        int tp = p; int tq = q;
        while (p <= m && t <= q) {
            if (a[p] <= a[t]) {
                s[k++] = a[p++];
            } else {
                s[k++] = a[t++];
            }
        }
        // 把剩余的也拷进去
        while (p <= m) {
            s[k++] = a[p++];
        }
        while (t <= q) {
            s[k++] = a[t++];
        }
        // 把临时数组中的数据拷贝到原数组中
        int k1 = 0;
        for (int u = tp; u <= tq; u++) {
            a[u] = s[k1++];
        }
    }

    /**
     * 快速排序 原地、不稳定
     * @param a
     * @param n
     */
    public static void quicksort(int[] a, int n) {
        quick_sort_c(a, 0, n-1);
    }

    /**
     * 递归算法
     * @param a
     * @param p
     * @param r
     */
    private static void quick_sort_c(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quick_sort_c(a, p, q-1);
        quick_sort_c(a, q+1, r);
    }

    /**
     * 获取隔断点-原地排序，采用双指针的方式
     * @param a
     * @param p
     * @param r
     */
    private static int partition(int[] a, int p, int r) {
        int i = p;
        int pivot = a[r];
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                ++i;
            }
        }
        swap(a, i, r);
        return i;
    }

    /**
     * 交换数组a中的i和j的元素
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
