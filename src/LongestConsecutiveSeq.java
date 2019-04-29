import java.util.*;

public class LongestConsecutiveSeq {
    /**
     * 使用HashSet法
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) return 1;

        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];

            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;
    }

    /**
     * 先排序法
     * @param nums
     * @return
     */
    public int longestConsecutive_bySort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        Arrays.sort(nums);
        int max = 1;
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == (nums[i-1] + 1))
                result++;
            else if (nums[i] == nums[i-1])
                continue;
            else {
                max = Math.max(max, result);
                result = 1;
            }
        }

        return Math.max(result, max);
    }

    /**
     * 并查集法
     */
    public int longestConsecutive_byUF(int[] nums) {
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

        public UF(int n) {
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
        LongestConsecutiveSeq test = new LongestConsecutiveSeq();
        int[] nums = {0, -1};
        System.out.println(test.longestConsecutive_bySort(nums));
    }
}
