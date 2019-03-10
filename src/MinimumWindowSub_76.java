import java.util.HashMap;

public class MinimumWindowSub_76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0;right < s.length();right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right),map.get(s.charAt(right))-1);

                if (map.get(s.charAt(right)) >= 0)
                    count++;
            }

            while (count == t.length()) { //子串包含t中的全部字母
                if (right - left + 1 < minLen) { //新的最小长度
                    minLeft = left;
                    minLen = right - left + 1;
                }

                if (map.containsKey(s.charAt(left))) { //左边界的字母是t中的，移动后子串就不满足包含t中全部字母的条件了
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0)
                        count--;
                }
                left++;
            }
        }

        if (minLen > s.length())
            return "";

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        int mod = (int)(1e9 + 7);
        System.out.println(1 % mod);
    }

}
