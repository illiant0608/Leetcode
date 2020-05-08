public class FirstUniqueCharInAString_387 {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0;i < s.length();i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length();i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharInAString_387 test = new FirstUniqueCharInAString_387();
        System.out.println(test.firstUniqChar("cc"));
    }
}
