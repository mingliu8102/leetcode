public class offer57 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int hi = len - 1;
        while (hi - 1 >= 0) {
            int res = helper(nums, 0, hi - 1, target - nums[hi]);
            if (res != Integer.MAX_VALUE) {
                return new int[]{res, nums[hi]};
            }
            hi--;
        }
        return new int[]{-1, -1};
    }

    public static int helper(int[] nums, int lo, int hi, int target) {

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
