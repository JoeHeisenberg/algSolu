package learn.alg.dynamic;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author: lph 2021-06-08
 */
public class Lee300 {

    /**
     * 动归
     *
     * @param nums
     * @return
     */
    public static int maxUpSubSeq(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心+二分查找
     *
     * @param nums
     * @return
     */
    public static int maxUpSubSeq1(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 0; i < n; i++) {
            if (d[len] < nums[i]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;    // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 4, 2, 7};
        System.out.println(maxUpSubSeq(nums));
        System.out.println(maxUpSubSeq1(nums));
    }
}
