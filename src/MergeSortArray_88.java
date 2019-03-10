public class MergeSortArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0)
            return;
        int[] aux = new int[m + n];
        int i = 0, j = 0;
        for (int k = 0;k < m + n;k++) {
            if (i >= m) aux[k] = nums2[j++];
            else if (j >= n) aux[k] = nums1[i++];

            else if (nums1[i] <= nums2[j]) {
                aux[k] = nums1[i++];
            }

            else aux[k] = nums2[j++];
        }

        for (int t = 0;t < aux.length;t++)
            nums1[t] = aux[t];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};

        MergeSortArray_88 test = new MergeSortArray_88();
        test.merge(nums1, 1, nums2, 1);
    }
}
