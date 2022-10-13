import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 作者：星星上的louie
 * 链接：https://www.nowcoder.com/discuss/685760?type=2&order=0&pos=20&page=1&channel=-1&source_id=discuss_tag_nctrack
 * 来源：牛客网
 * <p>
 * 给定一个序列S, 需要找一个尽可能长的子串, 使得子串的最大最小值不超过m, 输出子串的长度
 * input: [10,1,3,5,9] m = 4
 * output: 3
 * 思路是: 滑动窗口+ TreeMap
 */
public class zhijaing {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 3, 5, 9};
        System.out.println(helper(nums, 4));
    }

    private static int helper(int[] nums, int m) {
        //int left = 0;
        int right = 0;
        int n = nums.length;
        int max = 0;
        //list存放索引，使用List是因为可能有重复值
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        for (int left = 0; left < n; left++) {
            while (right < n) {
                if (treemap.containsKey(nums[right])) {
                    List<Integer> list = treemap.get(nums[right]);
                    list.add(right);
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(right);
                    treemap.put(nums[right], list);
                }
                //一定要++，避免重复计数
                right++;
                if (treemap.lastKey() - treemap.firstKey() > m) {

                    break;
                }

            }
            //left右移
            List<Integer> auxList = treemap.get(nums[left]);
            auxList.remove((Integer) left);
            if (auxList.isEmpty()) {
                treemap.remove(nums[left]);
            }
            int tmpLen = right - left - 1;
            max = Math.max(tmpLen, max);
        }
        return max;
    }
}
