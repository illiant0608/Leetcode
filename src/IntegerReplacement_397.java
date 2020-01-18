public class IntegerReplacement_397 {
    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                // 二进制下，如果n+1中1的数量大于n-1中1的数量
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }
    // 另外，判断方法可以简化成二进制下，如果以11结尾，就+1，如果以01结尾，就-1，因为最终的目的就是要最后两位变成00
}
