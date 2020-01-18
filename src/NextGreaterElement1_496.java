import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0;i < nums1.length;i++) {
            nums1[i] = find(nums1[i], nums2);
        }

        return nums1;
    }

    private int find(int target, int[] num) {
        int i;
        for (i = 0;i < num.length;i++) {
            if (num[i] == target)
                break;
        }
        if (i == num.length - 1)
            return -1;
        for (int j = i + 1;j < num.length;j++) {
            if (num[j] > num[i])
                return num[j];
        }

        return -1;
    }

    // 单调栈解法
    public int[] nextGreatElementByStack(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0;i < nums2.length;i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0;i < nums1.length;i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
