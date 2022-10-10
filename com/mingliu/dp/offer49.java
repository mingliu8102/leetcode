import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class offer49 {
    public int nthUglyNumber(int n) {
//        int[] dp = new int[n];
//        dp[0] = 1;
//        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        queue.add(1);
//        queue.add(5);
//        queue.add(2);
//        System.out.println(queue.peek());
        int[] factors = {2, 3, 5};
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        seen.add(1);
        queue.add(1);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = queue.poll();
            res = cur;
            for (int f : factors) {
                int tmp = cur * f;
                if (seen.add(tmp)) {
                    queue.add(tmp);
                }
            }
        }
        return res;
    }
}
