import java.util.Stack;

public class ValidBrackets_20 {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.empty() || c != stack.pop())
                return false;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidBrackets_20 test = new ValidBrackets_20();
        test.isValid("()[]{}");
    }
}
