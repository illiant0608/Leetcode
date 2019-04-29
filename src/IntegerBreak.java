public class IntegerBreak {
    public int integerBreak(int n) {
        int res = 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int i;
        for (i = n;i > 4;i -= 3) {
            res *= 3;

        }

        if (i == 4 || i == 2 || i == 3)
            res *= i;

        return res;
    }
}
