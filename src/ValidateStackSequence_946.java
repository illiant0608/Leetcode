import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidateStackSequence_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (Integer num : pushed) {
            stack.push(num);
            while (!stack.empty() && index < pushed.length && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }

        return index == popped.length;
    }

    public static void main(String[] args) {
        ValidateStackSequence_946 test = new ValidateStackSequence_946();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(test.validateStackSequences(pushed, popped));
    }
}
