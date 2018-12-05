import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        GenerateParentheses_22 test = new GenerateParentheses_22();
        System.out.println(test.generateParenthesis(3));
    }
}
