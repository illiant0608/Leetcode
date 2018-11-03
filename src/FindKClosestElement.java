import java.util.ArrayList;
import java.util.List;

public class FindKClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = (low + high) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                low = mid + 1;
            else
                high = mid;
        }

        for (int i = low;i <= low+k;i++) {
            list.add(arr[i]);
        }

        return list;
    }


}
