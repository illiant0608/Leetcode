public class PalindromicSubString_647 {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0;i < s.length();i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }



    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubString_647 test = new PalindromicSubString_647();
        System.out.println(test.countSubstrings(s));
    }
}
