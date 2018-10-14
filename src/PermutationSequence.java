import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int mod = 1;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1;i <= n;i++) {
            mod = mod * i;
            candidates.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < n;i++) {
            mod = mod / (n - i);
            int first = k / mod;
            k = k % mod;
            sb.append(candidates.get(first));
            candidates.remove(first);
        }

        return sb.toString();
    }
}
