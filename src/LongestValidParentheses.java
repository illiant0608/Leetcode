import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int start = 0;
        int longest = 0;
        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else if (s.charAt(i) == ')') {
                if (st.empty())
                    start = i + 1;
                else {
                    st.pop();
                    longest = st.empty() ? Math.max(longest, i - start + 1) : Math.max(longest, i - st.peek());
                }
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        test.longestValidParentheses("(()");
    }


}

