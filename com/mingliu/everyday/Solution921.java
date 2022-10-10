import java.util.Stack;

public class Solution921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("((("));
    }

    public static int minAddToMakeValid(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int size = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackAux = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    stackAux.push(c);
                } else {
                    stack.pop();
                }
            }

        }
        return stack.size() + stackAux.size();
    }
}
