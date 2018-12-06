public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0;i < 50;i++)
            if (n == Math.pow(2, i))
                return true;


        return false;
    }

    /**
     * 更快的办法
     * public boolean isPowerOfTwo(int n) {
     *     return n > 0 && Integer.bitCount(n) == 1;
     *     //如果是true,那么这个数的二进制中只有一个1
     * }
     */
}
