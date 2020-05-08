import java.util.Stack;

public class MinimumCostTreeFromLeafValues_1130 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // max_v[i][j]代表arr[i:j]区间中的最大值
        int[][] max_v = new int[n][n];

        for (int i = 0;i < n;i++)
            max_v[i][i] = arr[i];

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n;i++) {
                int j = i + d;
                max_v[i][j] = Math.max(max_v[i][j - 1], arr[j]);
            }
        }

        for (int i = 0;i < n - 1;i++) {
            dp[i][i+1] = arr[i] * arr[i+1]; // 紧挨着的两个元素
        }

        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                int cur_min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                    cur_min = Math.min(cur_min, dp[i][k] + dp[k+1][j] + max_v[i][k] * max_v[k+1][j]);
                dp[i][j] = cur_min;
            }
        }

        return dp[0][n-1];
    }


    // dfs 查找的是以s～e这一段构建树，这棵树中非叶节点的值的和
    public int dfs(int[] arr, int s, int e, int[][] dp) {
        if (s == e) return 0;
        if (dp[s][e] > 0) return dp[s][e];
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int left = dfs(arr, s, i, dp);
            int right = dfs(arr, i + 1, e, dp);
            int maxLeft = 0, maxRight = 0;
            for (int j = s; j <= i; j++) maxLeft = Math.max(maxLeft, arr[j]);
            for (int j = i + 1; j <= e; j++) maxRight = Math.max(maxRight, arr[j]);
            ans = Math.min(ans, left + right + maxLeft * maxRight);
        }
        dp[s][e] = ans;
        return ans;
    }

    // 类似贪心算法，永远找数组中最小的两个相乘，然后小的用完之后会被覆盖掉(因为在子树中就不是最大了)
    // 所以要从栈中丢掉
    public int stack_solution(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }

        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 8};
        MinimumCostTreeFromLeafValues_1130 test = new MinimumCostTreeFromLeafValues_1130();
        System.out.println(test.stack_solution(arr));
    }
}
