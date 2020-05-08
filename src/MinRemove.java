import java.util.Stack;

public class MinRemove {
    public String minRemove (String s) {
        // write code here
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c != '(' && c != ')') {
                if (stack.empty()) result.append(c);
                else stack.push(c);
            }

            if (c == '(') {
               stack.push(c);
            }

            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.empty() && stack.peek() == '(') {
                    sb.append(stack.pop());
                    sb = sb.reverse();
                    sb.append(c);
                }

                result.append(sb.toString());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MinRemove test = new MinRemove();
        System.out.println(test.minRemove("m(i(ho)yo)"));
    }
}
