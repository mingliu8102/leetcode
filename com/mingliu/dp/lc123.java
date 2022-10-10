public class lc123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy1 = new int[n];
        int[] sell1 = new int[n];
        int[] buy2 = new int[n];
        int[] sell2 = new int[n];
        //buy1[i]为到第i天完成购买一次股票后的收益；
        //sell1[i]为到第i天完成卖一次股票后的收益；
        //buy2[i]为到第i天完成购买2次股票后的收益；
        //sell2[i]为到第i天完成卖2次股票后的收益；
        //buy1[i]=max(buy1[i-1],-price[i]);
        //sell1[i]=max(sell1[i-1],buy1[i-1]+price[i])
        //buy2[i]=max(buy2[i-1],sell1[i-1]-price[i])
        //sell2[i]=max(sell2[i-1],buy2[i-1]+price[i])
        buy1[0] = -prices[0];
        sell1[0] = 0;
        buy2[0] = -prices[0];
        sell2[0] = 0;

        for (int i = 1; i < n; i++) {
            buy1[i] = Math.max(buy1[i - 1], -prices[i]);
            sell1[i] = Math.max(sell1[i - 1], buy1[i - 1] + prices[i]);
            buy2[i] = Math.max(buy2[i - 1], sell1[i - 1] - prices[i]);
            sell2[i] = Math.max(sell2[i - 1], buy2[i - 1] + prices[i]);
        }
        return Math.max(Math.max(sell1[n - 1], sell2[n - 1]), 0);
    }

}
