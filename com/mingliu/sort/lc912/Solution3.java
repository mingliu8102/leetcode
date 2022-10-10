public class Solution3 {
    public int[] sortArray(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        sort(nums, lo, hi);
        return nums;
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int cmp = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < cmp) if (i == hi) break;
            while (nums[--j] > cmp) if (j == lo) break;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private static void exch(int[] nums, int lo, int j) {
        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;
    }
}
