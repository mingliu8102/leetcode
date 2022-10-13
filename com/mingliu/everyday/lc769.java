public class lc769 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int right = n - 1;
        int count = 0;
        while (right >= 0) {
            
//            int tmp = arr[i];
//            while (arr[i] > tmp) {
//                i--;
//            }
//            count++;
//            i--;
            int tmp = arr[right];
            int left = right - 1;
            while (left >= 0 && arr[left] > tmp) {
                left--;
            }
            count++;
            right = left;
        }
        return count;
    }
}
