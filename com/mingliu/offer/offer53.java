public class offer53 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

    public static int missingNumber(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int lo, int hi) {
        if (lo > hi) return lo - 1;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == mid) {
            lo = mid + 1;

        } else if (nums[mid] < mid) {

        } else {
            hi = mid - 1;

        }
        return helper(nums, lo, hi);
    }
}
