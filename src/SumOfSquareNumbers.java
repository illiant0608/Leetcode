public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        double sqrt = Math.sqrt(c);
        double eps = 1e-10;
        for (int i = 0;i <= sqrt;i++) {
            double tmp = Math.sqrt(c - i*i);
            if ((tmp - Math.floor(tmp)) < eps)
                return true;
        }

        return false;
    }
}
