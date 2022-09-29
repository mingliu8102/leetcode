package offer45;

import java.util.Arrays;

class Solution {
    public String minNumber(int[] nums) {
        bubbleSort(nums);
//        StringBuilder sb=new StringBuilder();
//
//        for(int i:nums){
//            sb.append(i);
//        }
//        return sb.toString();
//        // return Arrays.toString(nums);
        //将数组转换为字符串的快捷写法
        return Arrays.toString(nums).replaceAll("\\[|]|,|\\s", "");
    }

    public static void bubbleSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j + 1 + i < N; j++) {
                // if(nums[j]>nums[j+1])
                //比较数字拼接后大小的快捷方法
                if (("" + nums[j] + nums[j + 1]).compareTo("" + nums[j + 1] + nums[j]) > 0)
                    exch(nums, j, j + 1);
            }
        }
    }

    public static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
