class Solutions {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        System.out.print(findKthLargest(nums, 2));
    }


    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        int lo = 0;
        int hi = nums.length - 1;
//        int p = k;
        //从小到达排序，转换k
        k = nums.length - k;
        while (lo < hi) {
            int p = partiton(nums, lo, hi);
            if (p < k) lo = p + 1;
            else if (p > k) hi = p - 1;
            else break;
        }
        //返回值为nums[k]，不是nums[p]
        return nums[k];
    }


    private static int partiton(int[] nums, int lo, int hi) {
        int p = lo;
        int i = lo, j = hi + 1;
        int cmp = nums[p];
        while (true) {
            while (nums[++i] < cmp) if (i == hi) break;
            while (nums[--j] > cmp) if (j == lo) break;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
