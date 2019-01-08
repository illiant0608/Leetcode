import java.util.Stack;

public class BasicCalculator_224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            if (Character.isDigit(chars[i]))
                number = 10 * number + (chars[i] - '0');
            else if (chars[i] == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (chars[i] == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (chars[i] == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (chars[i] == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if (number != 0)
            result += sign * number;
        return result;
    }
}
