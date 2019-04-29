import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
        //int[] dp = new int[arr.length];
        int maxIncome = 0;
        int min = arr[0];
        for (int i = 1;i < arr.length;i++) {
            int income = arr[i] - min;
            if (maxIncome < income) {
                maxIncome = income;
                min = arr[i];
            }
            else continue;

            min = Math.min(min, arr[i]);
        }

        System.out.println(maxIncome);
    }
}
