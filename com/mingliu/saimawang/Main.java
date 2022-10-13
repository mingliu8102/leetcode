import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        
//        input.next();
        String str = input.nextLine();
//        System.out.println(decode(str));
        System.out.println(str);
    }

    public static String decode(String str) {
        int len = str.length();
        //字符栈
        //操作数栈
        Stack<Integer> times = new Stack<>();
        Stack<String> aux = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == '[') {

            } else if (c > '0' && c <= '9') {
                times.add(c - '0');
            } else if (c == '|') {
                aux.add(c + "");
            } else if (c == ']') {
                int time = times.pop();
                String tmp = "";
                while (true) {
                    String s = aux.pop();
                    if (s.equals("|")) {
                        break;
                    } else {
                        tmp = s + tmp;
                    }
                }
                String tmpS = "";
                for (int k = 0; k < time; k++) {
                    tmpS += tmp;
                }
                aux.add(tmpS);
            } else {
                aux.add(c + "");
            }

        }
        String res = "";
        while (!aux.isEmpty()) {
            res = aux.pop() + res;
        }
        return res;
    }
}
