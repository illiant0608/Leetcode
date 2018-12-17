import java.util.Stack;

public class SumOfSubarrayMini_907 {
    public int sumSubarrayMins(int[] A) {
        final int kmod = (int)1e9 + 7;
        final int n = A.length;
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> lens = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;

        for (int i = 0;i < n;i++) {
            int len = 1;
            while (!nums.empty() && nums.peek() > A[i]) {
                len += lens.pop();
                nums.pop();
            }

            nums.push(A[i]);
            lens.push(len);
            left[i] = len;
        }

        nums.clear();
        lens.clear();

        for (int i = n-1;i >= 0;i--) {
            int len = 1;
            while (!nums.empty() && nums.peek() >= A[i]) {
                len += lens.pop();
                nums.pop();
            }

            nums.push(A[i]);
            lens.push(len);
            right[i] = len;
        }

        for (int i = 0;i < n;i++) {
            ans = (int) (ans + (long) A[i] * left[i] * right[i]) %kmod;
        }

        return ans;
    }
}
