import java.util.Stack;

public class NextGreaterElement2_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // 保证能和另一边的也比较到，从而实现循环
        for (int i = 2 * nums.length - 1;i >= 0;i--) {
            while (!stack.empty() && stack.peek() <= nums[i % nums.length])
                stack.pop();
            res[i%nums.length] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }

        return res;
    }
}
