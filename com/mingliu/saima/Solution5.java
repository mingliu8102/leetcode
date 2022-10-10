class Solution5 {
    public static void main(String[] args) {
        System.out.println(solution("AAAAAA"));
    }

    public static int solution(String str) {
        int count = 0;
        if (str.length() == 0) return 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (Character.isUpperCase(str.charAt(i))) {
                    count += 2;
                } else {
                    count++;
                }
                continue;
            }
            if (Character.isUpperCase(str.charAt(i)) && !Character.isUpperCase(str.charAt(i - 1))) {
                count += 2;
            } else if (!Character.isUpperCase(str.charAt(i)) && Character.isUpperCase(str.charAt(i - 1))) {
                count += 2;
            } else {
                count++;
            }
        }
        return count;
    }

    public static int solution2(String str) {
        int small = 0;
        int big = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                int val1 = Math.min(small + 2, big + 2);
                int val2 = Math.min(small + 2, big + 1);
                small = val1;
                big = val2;
            } else {
                int va = Math.min(small + 1, big + 2);
                big = Math.min(small + 2, big + 2);
            }
        }
        return Math.min(small, big);
    }
}
