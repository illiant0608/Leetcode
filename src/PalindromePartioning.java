import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    ArrayList<String> currentList;
    List<List<String>> resultLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<>();
        currentList = new ArrayList<>();
        backTrack(s, 0);
        return resultLst;
    }

    public void backTrack(String s, int l) {
        if (currentList.size() > 0 && l >= s.length()) {
            List<String> r = (ArrayList<String>) currentList.clone();
            resultLst.add(r);
        }

        for (int i = l; i < s.length();i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i)
                    currentList.add(Character.toString(s.charAt(i)));
                else
                    currentList.add(s.substring(l, i+1));
                backTrack(s, l+1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
