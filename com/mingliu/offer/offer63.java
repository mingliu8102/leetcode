public class offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int max = prices[0];
        int proMax = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                proMax = Math.max(proMax, max - min);
            } else if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }
        return Math.max(proMax, max - min);
    }
}
