public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int water = 0;
        while (left < right) {
            water = Math.max(water, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) left++;
            else right--;
        }

        return water;
    }
}
