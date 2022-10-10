import java.util.Arrays;

public class lc927 {
    public static void main(String[] args) {
        int[] res = threeEqualParts(new int[]{1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0});
        for (int i : res) {
            System.out.println(i);
        }


    }

    //    public static int[] threeEqualParts(int[] arr) {
//
//        int len = arr.length;
//        if (len < 3) return new int[]{-1, -1};
//        int lo = 0;
//        int hi = len - 1;
//        int leftSum = arr[0];
//        int midSum = 0;
//        int rightSum = arr[len - 1];
//        for (int i = lo + 1; i < hi; i++) {
//            midSum = midSum * 2 + arr[i];
//        }
//        while (lo < hi) {
//            if (leftSum == midSum && leftSum == rightSum) {
//                return new int[]{lo, hi};
//            }
//            if (leftSum < rightSum) {
//                lo++;
//                leftSum = leftSum * 2 + arr[lo];
//                midSum = midSum - (int) (arr[lo] * Math.pow(2, hi - lo - 1));
//            } else if (leftSum >= rightSum) {
//                hi--;
//                rightSum = (int) (arr[hi] * Math.pow(2, len - 1 - hi)) + rightSum;
//                midSum = midSum / 2;
//            }
////            else {
////
////            }
//        }
//        return new int[]{-1, -1};
//    }
//    public static int[] threeEqualParts(int[] arr) {
//        int[] a = new int[]{123};
//
//    }
//    public static int[] threeEqualParts(int[] arr) {
//        String arrstr = Arrays.toString(arr);
//        arrstr = arrstr.replaceAll(" +|,", "");
//        arrstr = arrstr.substring(1, arrstr.length() - 1);
//        int len = arrstr.length();
//        if (len < 3) return new int[]{-1, -1};
//        int lo = 0;
//        int hi = len - 1;
//        long left;
//        long mid;
//        long right;
//        while (lo < hi) {
//
//            left = Long.parseLong(arrstr.substring(0, lo + 1));
//            mid = Long.parseLong(arrstr.substring(lo + 1, hi));
//            right = Long.parseLong(arrstr.substring(hi, len));
//            if (left == mid && left == right) {
//                return new int[]{lo, hi};
//            } else if (left < right) {
//                lo++;
//            } else if (left > right) {
//                hi--;
//            } else {
//                hi--;
//            }
//        }
//        return new int[]{-1, -1};
//    }
    public static int[] threeEqualParts(int[] arr) {
        if (arr.length < 3) return new int[]{-1, -1};
        int sum = Arrays.stream(arr).sum();
        int len = arr.length;
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }
        int part = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == part) {
                    second = i;
                } else if (cur == 2 * part) {
                    third = i;
                }
                cur++;
            }
        }
        int length = len - third;
//        if (second - first != third - second || third - second != len - third) {
//            return new int[]{-1, -1};
//        }
        if (first + length <= second && second + len <= third) {
            int i = 1;
            while (third + i < len) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{second - 1, third};
        }
        return new int[]{-1, -1};
    }
}
