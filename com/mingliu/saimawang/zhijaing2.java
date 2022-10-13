/**
 * 作者：星星上的louie
 * 链接：https://www.nowcoder.com/discuss/685760?type=2&order=0&pos=20&page=1&channel=-1&source_id=discuss_tag_nctrack
 * 来源：牛客网
 * <p>
 * 一个游戏的副本, 有一排需要打败的怪物, 初始状态下, 每个怪物1点血, 希望从左到右击杀这些怪物, 怪物分为0型和1型, 0型怪物1血, 1型怪物击杀后会给后面的0型怪物+1血
 * 你每次挥刀扣怪物1血, 问你打完这些怪物需要挥刀多少次
 * input = [0,1,0,1]
 * output = 5
 */
public class zhijaing2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1};
        System.out.println(helper(nums));
    }

    private static int helper(int[] nums) {
        int n = nums.length;
        //统计当前数后面有多少个0
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + (nums[i + 1] == 0 ? 1 : 0);
        }
        int count = 0;
        //如果是0，砍一刀；如果是1，除了砍一刀，还要多砍后面0的加血
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count += 1;
            } else {
                count++;
                count += dp[i];
            }
        }
        return count;
    }
}
