/**
 * leetcode 4
 */
public class MedianOfTwoSortedArray {
    /**
     * 合并数组做法，实际复杂度超出了，最坏情况下为O(nlogn)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        for (int k = 0;k < nums1.length + nums2.length;k++) {
            if (i >= nums1.length) total[k] = nums2[j++];
            else if (j >= nums2.length) total[k] = nums1[i++];
            else if (nums1[i] < nums2[j])
                total[k] = nums1[i++];
            else
                total[k] = nums2[j++];
        }

        double median = 0;
        if (total.length % 2 == 0) {
            median = (total[total.length / 2 -1] + total[total.length / 2]) / 2.0;
        } else
            median = total[total.length / 2];

        return median;
    }

    public double find2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;

        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);

        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2)
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        else
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }

    

}
