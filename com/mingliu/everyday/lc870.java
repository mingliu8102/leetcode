import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc870 {
    public static void main(String[] args) {
//        PriorityQueue queue = new PriorityQueue(new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return a - b;
//            }
//        });
//        queue.add(1);
//        queue.add(3);
//        queue.add(2);
//        System.out.println(queue.peek());
//        PriorityQueue queueBig = new PriorityQueue(new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return b - a;
//            }
//        });
//        queueBig.add(1);
//        queueBig.add(3);
//        queueBig.add(2);
//        System.out.println(queueBig.peek());
        int[] nums1 = new int[]{2, 0, 4, 1, 2};
        int[] nums2 = new int[]{1, 3, 0, 0, 2};
        int[] res = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[] aux = Arrays.copyOf(nums2, nums2.length);
        Arrays.sort(aux);
        int len = nums1.length;
        int[] res = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        int hi = len - 1;
        int i = 0;
        int j = 0;
        while (i < len) {
            if (nums1[i] <= aux[j]) {
                map.put(aux[hi], nums1[i]);
                hi--;
            } else {
                map.put(aux[j], nums1[i]);
                j++;
            }
            i++;
        }


        for (int i2 = 0; i2 < len; i2++) {
            res[i2] = map.get(nums2[i2]);
        }
        return res;
    }

//    private int[] helper(int[] nums1, int[] nums2) {
//        PriorityQueue<Integer> queueSmall = new PriorityQueue(new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return a - b;
//            }
//        });
//        PriorityQueue<Integer> queueBig = new PriorityQueue(new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return b - a;
//            }
//        });
//        for (int num : nums1) {
//            queueBig.add(num);
//            queueSmall.add(num);
//        }
//        int[] aux = Arrays.copyOf(nums2, nums2.length);
//        Arrays.sort(aux);
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : aux) {
//            if (num > queueBig.peek()) {
//                int tmp = queueSmall.poll();
//                map.put(num, tmp);
//            }
//        }
//
//    }

}
