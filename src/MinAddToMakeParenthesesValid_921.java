import java.util.Stack;

public class MinAddToMakeParenthesesValid_921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        char[] arr = S.toCharArray();
        for (char ch : arr) {
            if (stack.size() != 0 && stack.peek() == '(' && ch == ')') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        MinAddToMakeParenthesesValid_921 test = new MinAddToMakeParenthesesValid_921();
        System.out.println(test.minAddToMakeValid("()))(("));
    }
}
