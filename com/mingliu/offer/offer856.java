import java.util.Stack;

public class offer856 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> zuo = new Stack<>();
        int score = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                zuo.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (zuo.size() == 0) {
                    stack.add(1);
                } else {
                    zuo.pop();
                    
                }
            }
        }
    }
}
