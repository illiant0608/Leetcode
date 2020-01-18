import java.util.Random;

// 要验证一个洗牌算法的正确性，首先的一条就是必须要有n!种结果
public class ShuffleArray_384 {
    private int[] origin_arr;
    private int[] shuffle_arr;
    Random rand = new Random();

    public ShuffleArray_384(int[] nums) {
        this.origin_arr = nums;
        this.shuffle_arr = new int[origin_arr.length];
        System.arraycopy(origin_arr, 0, shuffle_arr, 0, origin_arr.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.origin_arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int pos;
        for (int i = shuffle_arr.length;i >= 0;i--) {
            pos = rand.nextInt(shuffle_arr.length);
            // swap
            int temp = shuffle_arr[i];
            shuffle_arr[i] = shuffle_arr[pos];
            shuffle_arr[pos] = temp;
        }

        return this.shuffle_arr;
    }
}
