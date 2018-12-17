public class MaximizeSeat_849 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int max = 0;
        int i = 0;
        while (i < n) {
            while (i < n && seats[i] == 1){
                i++;
            }

            int j = i;
            while (i < n && seats[i] == 0)
                i++;
            if (j == 0 || i == n)
                max = Math.max(max, i - j);
            else
                max = Math.max(max, (i-j+1) / 2);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1, 0, 1};
        MaximizeSeat_849 test = new MaximizeSeat_849();
        System.out.println(test.maxDistToClosest(nums));
    }
}
