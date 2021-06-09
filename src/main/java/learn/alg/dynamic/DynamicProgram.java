package learn.alg.dynamic;

/**
 * 动态规划
 * refer:https://blog.csdn.net/u013309870/article/details/75193592
 *
 * @author: lph 2021-06-08
 **/
public class DynamicProgram {

    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public static int fib0(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib0(n - 1) + fib(n - 2);
    }

    /**
     * 自顶向下备忘录法
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        return fib(n, memo);

    }

    private static int fib(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = 1;
        } else {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 自底向上动归
     * 指针移位，迭代计算
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int memo_pre = 0;
        int memo_mid = 1;
        int memo_curr = 1;
        for (int i = 2; i <= n; i++) {
            memo_curr = memo_mid + memo_pre;
            memo_pre = memo_mid;
            memo_mid = memo_curr;
        }
        return memo_curr;
    }

    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21
        int expect = 21;
        if (expect == fib0(8)) {
            System.out.println("true");
        }
        if (expect == Fibonacci(8)) {
            System.out.println("true");
        }
        if (expect == fib(8)) {
            System.out.println("true");
        }
    }
}
