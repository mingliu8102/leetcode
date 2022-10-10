public class lc154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5}));
        System.out.println();
        
    }

    public static int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }
}
