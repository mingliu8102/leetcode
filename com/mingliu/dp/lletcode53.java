public class lletcode53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[nums.length];
        //dp[i]表示以num[i]结尾的最大子数组和
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
