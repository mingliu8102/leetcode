public class Solution2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.print(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = nums[i - 1];
        }
        for (int i = N / 2; i >= 1; i--) {
            sink(arr, i, N);
        }
        int res = 0;
        for (int j = 1; j <= k; j++) {
            res = arr[1];
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
        return res;
    }

    private static void sink(int[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && nums[j + 1] > nums[j]) j++;
            if (!less(nums, k, j)) break;
            exch(nums, k, j);
            k = j;
        }
    }

    private static void exch(int[] nums, int k, int j) {
        int tmp = nums[k];
        nums[k] = nums[j];
        nums[j] = tmp;
    }

    private static boolean less(int[] nums, int k, int j) {
        return nums[k] < nums[j];
    }

}
