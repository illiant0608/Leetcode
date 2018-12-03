public class REMatching_10 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2)))
                return true;
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
                return isMatch(s.substring(1), p); //一个一个消
            return false;
        } else {
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
                return isMatch(s.substring(1), p.substring(1));
            return false;
        }
    }

    //dp solution


    public static void main(String[] args) {
        REMatching_10 test = new REMatching_10();
        System.out.println(test.isMatch("mississippi", "mis*is*ip*."));
    }
}
