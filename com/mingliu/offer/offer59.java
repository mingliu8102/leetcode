import java.util.PriorityQueue;

public class offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //比较器的简单写法，注意范型一定要写上具体的类型
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k - 1; i++) {
            pq.add(new int[]{nums[i], i});
        }
        for (int i = k - 1; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
