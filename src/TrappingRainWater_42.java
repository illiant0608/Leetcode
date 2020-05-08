import java.util.Arrays;

public class TrappingRainWater_42 {
    public int trap_twopt(int[] height) {
        if (height.length < 3) return 0;
        int leftmax = height[0], rightmax = height[height.length - 1];
        int water = 0;
        int left = 1, right = height.length - 2;

        while (left <= right) {
            if (leftmax <= rightmax) {
                leftmax = Math.max(leftmax, height[left]);
                water += leftmax - height[left];
                left++;
            } else {
                rightmax = Math.max(rightmax, height[right]);
                water += rightmax - height[right];
                right--;
            }
        }

        return water;
    }

    public int trap(int[] height) {
        int water = 0;
        int length = height.length;
        for (int i = 1;i < length - 1;i++) {
            int max_left = 0, max_right = 0;
            for (int j = i;j >= 0;j--)
                max_left = Math.max(max_left, height[j]);
            for (int j = i;j < length;j++)
                max_right = Math.max(max_right, height[j]);

            water += Math.min(max_left, max_right) - height[i];
        }

        return water;
    }

    public boolean canTrap(int i, int j, int[] height) {
        if (i == 0 || i == height.length - 1) return false;
        boolean left_flag = false, right_flag = false;
        for (int left = i - 1;left >= 0;left--)
            if (height[left] >= j) {
                left_flag = true;
                break;
            }

        for (int right = i + 1;right < height.length;right++) {
            if (height[right] >= j) {
                right_flag = true;
                break;
            }
        }

        return left_flag && right_flag;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater_42 test = new TrappingRainWater_42();
        System.out.println(test.trap(input));
    }
}
