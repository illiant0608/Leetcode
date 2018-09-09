import java.util.HashSet;
import java.util.Set;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int count = 0;

        int[] position = new int[2];

        if (a.length != b.length)
            return false;
        if (a.length == 0)
            return false;

        for (int i = 0;i < a.length;i++) {
            if (a[i] != b[i]){
                count++;
                if (count > 2)
                    return false;
                position[count-1] = i;
            }
            return false;
        }

        if (count == 0) {
            Set<Character> set = new HashSet<>();
            for (char c: a) {
                if (set.contains(c))
                    return true;
                set.add(c);
            }
        }

        if (count == 1)
            return false;
        if (a[position[0]] != b[position[1]] || a[position[1]] != b[position[0]])
            return false;
        return true;
    }

}
