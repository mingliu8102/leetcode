public class offer46 {
    public int translateNum(int num) {

        String str = "" + num;
        int len = str.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;//1个数都没加入
        dp[1] = 1;//加入1个数
        for (int i = 2; i <= len; i++) {
            if (Integer.parseInt(str.substring(i - 2, i)) < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
