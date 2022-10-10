public class Solution777 {
    private static String start, end;

    public boolean canTransform(String start, String end) {

    }

    private static void modifyStr(String str) {
        //将所有L左移，所有R右移
        int len = str.length();
        char[] arr = str.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == 'R' && i + 1 < len && arr[i + 1] == 'X') {

            }
        }
    }

    ;

    private static void exch(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    private static int count(String str) {
        int count = 0;
        int len = str.length();
        char[] arr = str.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == 'R' && i + 1 < len && arr[i + 1] == 'X') {
                count++;
            }
        }
        return count;
    }

}
