import java.util.Comparator;
import java.util.PriorityQueue;

public class offer123 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        PriorityQueue<Integer> queueBig = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                profit = Math.max(profit, max - min);
            } else if (prices[i] < max) {
                min = prices[i];
                max = prices[i];
                queueBig.add(profit);
            }
        }
        queueBig.add(max - min);
        if (queueBig.size() == 0) return 0;
        if (queueBig.size() < 2) return queueBig.poll();
        else return queueBig.poll() + queueBig.poll();
    }
}
