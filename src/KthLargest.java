import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();

        for (int num: nums) {
            queue.offer(num);
            //只需要k个元素
            if (queue.size() > k)
                queue.poll();
        }
    }

    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        queue = new PriorityQueue<>();

        for (int num: nums) {
            queue.offer(num);
            //只需要k个元素
            if (queue.size() > k)
                queue.poll();
        }

        return queue.poll();
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k)
            queue.poll();
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }
}
