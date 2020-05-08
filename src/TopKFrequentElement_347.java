import java.util.*;

public class TopKFrequentElement_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        pq.addAll(map.keySet());

        for (int i = 0;i < k;i++) {
            if (!pq.isEmpty()) {
                result.add(pq.poll());
            }
        }

        return result;
    }
}
