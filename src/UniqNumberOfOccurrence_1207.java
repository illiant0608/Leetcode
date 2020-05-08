import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqNumberOfOccurrence_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        int[] count_arr = new int[max - min + 1];

        for (int i : arr) {
            count_arr[i - min]++;
        }

        Arrays.sort(count_arr);

        for (int i = 0;i < count_arr.length - 1;i++) {
            if (count_arr[i] != 0 && count_arr[i] == count_arr[i + 1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        UniqNumberOfOccurrence_1207 test = new UniqNumberOfOccurrence_1207();
        System.out.println(test.uniqueOccurrences(arr));
    }
}
