public class IsSubsequence_392 {
    // O(len(t))
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int s_pos = 0;
        for (int i = 0;i < t.length();i++) {
            if (t_arr[i] == s_arr[s_pos])
                s_pos++;

            if (s_pos >= s.length())
                return true;
        }

        return false;
    }

    // O(len(s))
    public boolean isSubsequence_2(String s, String t) {
        int index=0;
        for(int i=0;i<s.length();i++) {
            String sub = s.substring(i,i+1);
            int idx = t.indexOf(sub,index);
            if(idx!=-1) {
                index=idx+1;
            }
            else
                return false;
        }
        return true;

    }
}
