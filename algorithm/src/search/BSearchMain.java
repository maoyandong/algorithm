package search;

/**
 * @author: MaoYanDong
 * @create: 2023-01-10 10:34
 * @Version 1.0
 * @description: 二分查找算法Demo
 */
public class BSearchMain {
    public static void main(String[] args) {
        int[] a = {1,2,4,6,7,9,12,18,22,29,36};
        int index = bSearch(a, a.length, 18);
        System.out.println(index);
        int index02 = bSearchRe(a, a.length, 18);
        System.out.println(index02);

    }

    /**
     * 二分查找-非递归方式
     * @param a
     * @param n
     * @param val
     * @return
     */
    public static int bSearch(int[] a, int n, int val) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == val) {
                return mid;
            }
            if (a[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    /**
     * 二分查找-递归方式
     * @param a
     * @param n
     * @param val
     * @return
     */
    public static int bSearchRe(int[] a, int n, int val) {
        return bSearchInternally(a, 0, n - 1, val);
    }

    /**
     * 最简单的二分查找
     * @param a
     * @param low
     * @param high
     * @param val
     * @return
     */
    private static int bSearchInternally(int[] a, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == val) {
            return mid;
        } else if (a[mid] < val) {
            return bSearchInternally(a, mid + 1, high, val);
        } else {
            return bSearchInternally(a, low, mid - 1, val);
        }
    }

    /**
     * 二分查找的几个变种
     */

}
