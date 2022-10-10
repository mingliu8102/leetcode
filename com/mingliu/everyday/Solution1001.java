class Solution1001 {
    public static void main(String[] args) {
        System.out.print(reformatNumber(args[0]));
    }

    public static String reformatNumber(String number) {
        String str = number.replaceAll("-| +", "");
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        int yushu = len % 3;
        int shu = len / 3;
        int i = 0;
        if (yushu == 0) {
            for (int j = 0; j < shu; j++) {
                sb.append(str.substring(i, i + 3));
                if (j != shu - 1) {
                    sb.append("-");
                }
                i = i + 3;
            }
        } else if (yushu == 1) {
            for (int j = 0; j < shu - 1; j++) {
                sb.append(str.substring(i, i + 3));
                if (j != shu - 1) {
                    sb.append("-");
                }
                i = i + 3;
            }
            sb.append(str.substring(len - 4, len - 2));
            sb.append("-");
            sb.append(str.substring(len - 2, len));
        } else if (yushu == 2) {
            for (int j = 0; j < shu; j++) {
                sb.append(str.substring(i, i + 3));
//                if (j != shu - 1) {
                sb.append("-");
//                }
                i = i + 3;
            }
            sb.append(str.substring(len - 2, len));
        }
        return sb.toString();
    }
}
