import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSeq_128 {
    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer, Integer> map = new HashMap<>(); // <value, index>
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(nums[i]))
                continue;

            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1))
                uf.union(i, map.get(nums[i] + 1));
            if (map.containsKey(nums[i] - 1))
                uf.union(i, map.get(nums[i] - 1));

        }

        return uf.maxUnion();
    }

    class UF {
        private int[] list;

        public UF(int n ) {
            list = new int[n];
            for (int i = 0;i < n;i++) {
                list[i] = i;
            }
        }

        public int root(int i) {
            while (i != list[i]) {
                list[i] = list[list[i]];
                i = list[i];
            }

            return i;
        }

        public boolean connected(int i, int j) {
            return root(i) == root(j);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            list[i] = j;
        }

        //returns the maximum size of union
        public int maxUnion() {
            int[] count = new int[list.length];
            int max = 0;
            for (int i = 0;i < list.length;i++) {
                count[root(i)]++;
                max = Math.max(max, count[root(i)]);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSeq_128 test = new LongestConsecutiveSeq_128();
        int[] list = {100, 4, 200, 1, 3, 2};
        System.out.println(test.longestConsecutive(list));
    }
}
