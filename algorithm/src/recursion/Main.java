package recursion;

/**
 * @author: MaoYanDong
 * @create: 2023-01-04 15:33
 * @Version 1.0
 * @description: 主测试类
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(stepWays(7));
    }

    /**
     * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，
     * 请问走这 n 个台阶有多少种走法？
     * 如果有 7 个台阶，你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2 这样子上去，总之走法有很多，
     * 那如何用编程求得总共有多少种走法呢？
     * @param n 假设有n阶台阶
     * @return
     */
    public static int stepWays(int n) {

        /* 代码存在的问题：1.容易造成栈溢出 2.重复计算，想要计算 f(5)，需要先计算 f(4) 和 f(3)，而计算 f(4) 还需要计算 f(3)，因此，f(3) 就被计算了很多次，这就是重复计算问题 */
        // 终止条件1：只剩下一节台阶
        if (n == 1) {
            return 1;
        }
        // 终止条件2：只剩下二节台阶
        if (n ==2) {
            return 2;
        }
        // 递归公式：n节台阶可以分为第一次走一节或者第一次走二节
        return stepWays(n - 1) + stepWays(n - 2);
    }

    /**
     * 所有的递归问题都可以转为这种非递归的实现方式
     * @param n
     * @return
     */
    public static int stepWays02(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}
