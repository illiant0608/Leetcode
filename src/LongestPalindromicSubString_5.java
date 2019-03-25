public class LongestPalindromicSubString_5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = null;
        int n = s.length();
        for (int i = 0;i < s.length();++i)
            dp[i][i] = true;

        for (int i = 0;i < s.length() - 1;++i) {
            if (s.charAt(i) == s.charAt(i+1))
                dp[i][i+1] = true;
        }

        for (int i = n - 1;i >= 0;i--) {
            for (int j = i;j < n;j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);

                if (dp[i][j] && (res == null || res.length() < j-i+1))
                    res = s.substring(i, j+1);
            }
        }

        return res;


    }
}
