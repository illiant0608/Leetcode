import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        String new_S = resolve(S);
        String new_T = resolve(T);

        if (new_S.equals(new_T))
            return true;
        else return false;
    }

    public String resolve(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i < S.length();i++) {
            if (S.charAt(i) != '#')
                stack.push(S.charAt(i));
            else {
                if (!stack.empty())
                    stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}
