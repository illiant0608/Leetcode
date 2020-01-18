public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1)
                count++;
            i = i >> 1;
        }
        return count;
    }
}
