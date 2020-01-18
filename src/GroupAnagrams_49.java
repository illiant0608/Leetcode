import java.util.*;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sorted_string = sort_string(str);
            if (map.containsKey(sorted_string)) {
                map.get(sorted_string).add(str);
            } else {
                List<String> value = new LinkedList<>();
                value.add(str);
                map.put(sorted_string, value);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    private String sort_string(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        GroupAnagrams_49 test = new GroupAnagrams_49();
        String[] array = {"eat","tea","tan","ate","nat","bat"};
        test.groupAnagrams(array);
    }
}
