public class BinarySearch {
    public int binary_search(int[] arr, int num) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                int j = mid;
                for (;j >= 0;j--) {
                    if (arr[j] != num) break;
                }
                return j + 1;
            }
            else if (arr[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 5};
        BinarySearch test = new BinarySearch();
        System.out.println(test.binary_search(arr, 2));
    }
}
