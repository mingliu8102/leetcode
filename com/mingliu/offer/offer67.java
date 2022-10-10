public class offer67 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int sign = 1;
        int res = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
        }
        int bound = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }
            if (res > bound) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + c - '0';
            }
        }
        return res;
    }
}
