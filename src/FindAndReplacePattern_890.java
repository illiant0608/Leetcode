import java.util.*;

public class FindAndReplacePattern_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = normalise(pattern);
        List<String> result = new ArrayList<>();
        for (String w : words) {
            if (Arrays.equals(normalise(w), p))
                result.add(w);
        }

        return result;
    }

    public int[] normalise(String w) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0;i < n;i++) {
            map.putIfAbsent(w.charAt(i), map.size());
            res[i] = map.get(w.charAt(i));
        }

        return res;
    }

    public static void main(String[] args) {
        FindAndReplacePattern_890 test = new FindAndReplacePattern_890();

        int[] res = test.normalise("abc");
        for (int i = 0;i < res.length;i++)
            System.out.print(res[i] + " ");
    }
}
