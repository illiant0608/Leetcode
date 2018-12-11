public class CustomSortString_791 {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a'];}
        StringBuilder sb = new StringBuilder();

        //S里有的字母
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        //S里没有的字母
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
