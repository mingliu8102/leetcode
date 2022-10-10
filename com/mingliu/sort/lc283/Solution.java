class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i : arr) System.out.println(i);
    }

    public static void moveZeroes(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j + i + 1 < N; j++) {
                if (nums[j] == 0 && nums[j + 1] != 0) exch(nums, j, j + 1);
            }
        }
    }

    private static void exch(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
