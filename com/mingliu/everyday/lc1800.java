public class lc1800 {
    public int maxAscendingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        if (len == 0) return 0;
        int tmp = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                tmp += nums[i];
            } else {
                max = max < tmp ? tmp : max;
                tmp = nums[i];
            }
        }
        return Math.max(tmp, max);
    }
}
