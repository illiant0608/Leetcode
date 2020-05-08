import java.util.*;

// top k 问题 priority queue
public class TopKFrequentWord_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2))
                    return o1.compareTo(o2);

                return map.get(o2) - map.get(o1);
            }
        });

        pq.addAll(map.keySet());
        List<String> result = new ArrayList<>();

        for (int i = 0;i < k;i++) {
            if (!pq.isEmpty()) {
                result.add(pq.poll());
            }
        }

        return result;
    }
}
