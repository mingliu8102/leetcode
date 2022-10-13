import java.util.Arrays;
import java.util.Scanner;

class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // in.nextLine();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(maxRen(arr));
    }

    private static int maxRen(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
//        Set<Integer> set = new HashSet();
//        for (int i = n - 1; i >= 0; i--) {
//            while (arr[i] > 0 && set.contains(arr[i])) {
//                arr[i] = arr[i] - 1;
//            }
//            if (arr[i] > 0) {
//                set.add(arr[i]);
//                sum += arr[i];
//            }
//        }
        int duoyu = 0;
        sum += arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != arr[i + 1]) {
                sum += arr[i];
                //处理多余人员
                for (int j = arr[i + 1] - 1; j > arr[i]; j--) {
                    if (duoyu <= j) {
                        sum += duoyu;
                        duoyu = 0;
                        break;
                    } else {
                        sum += j;
                        duoyu = duoyu - j;
                    }
                }

            } else {
                duoyu += arr[i];
            }
        }
        //处理多余人员
        for (int j = arr[0] - 1; j > 0; j--) {
            if (duoyu <= j) {
                sum += duoyu;
                duoyu = 0;
                break;
            } else {
                sum += j;
                duoyu = duoyu - j;
            }
        }
        return sum;
    }
}

