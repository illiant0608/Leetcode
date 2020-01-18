import java.util.Arrays;

public class NextGreaterElement3_556 {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        int len = str.length();
        int i = len - 1;

        for(; i > 0;i--) {
            if (arr[i] > arr[i-1]) break;
        }
        if (i == 0) return -1;
        for (int j = len - 1;j >= i; j--) {
            if (arr[j] > arr[i-1]) {
                char tmp = arr[j];
                arr[j] = arr[i-1];
                arr[i-1] = tmp;
                break;
            }
        }

        // 需要保持最小
        Arrays.sort(arr, i, arr.length);

        long value = Long.parseLong(new String(arr));
        return (value <= Integer.MAX_VALUE) ? (int)value : -1;
    }

    public static void main(String[] args) {
        NextGreaterElement3_556 test = new NextGreaterElement3_556();
        test.nextGreaterElement(1999999999);
    }
}
