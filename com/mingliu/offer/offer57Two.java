import java.util.ArrayDeque;
import java.util.Queue;

public class offer57Two {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(15));
        String s = "a";
        s.trim();

    }

    static Queue<int[]> queue;

    public static int[][] findContinuousSequence(int target) {
        queue = new ArrayDeque<>();
        int left = 1;
        int right = 1;
        helper(target, left);
        int size = queue.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    private static void helper(int target, int left) {
        int sum = left;
        int right = left;
        while (left < target / 2) {
            while (sum < target) {
                right++;
                sum += right;

            }
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target) {
                int[] ans = new int[right - left + 1];
                int tmp = left;
                for (int i = 0; i < right - left + 1; i++) {
                    ans[i] = tmp;
                    tmp++;
                }
                queue.add(ans);
            }
            right++;
            sum += right;
        }
    }
}
