public class AvgWithoutOverflow {
    public static int getAvg (int[] arr) {
        // 求整个数组的平均值并防止溢出
        int len = arr.length;
        int avg = 0;
        int mod = 0;
        for (int i : arr) {
            avg += i / len;
        }
        for (int i : arr) {
            mod += i % len;
        }

        return avg + mod / len;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(getAvg(arr));
    }
}
