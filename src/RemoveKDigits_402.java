public class RemoveKDigits_402 {
    // using no extra space
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        while (k > 0) {
            num = removeOneDigit(num);
            k--;
        }
        while (num.startsWith("0") && num.length() > 1) {
            num = num.substring(1);
        }
        return num;
    }

    private String removeOneDigit(String str) {
        for (int i = 0;i < str.length() - 1;i++) {
            int value_i = str.charAt(i) - '0';
            int value_j = str.charAt(i+1) - '0';

            if (value_i > value_j) {
                // 去掉i位置的字符
                return str.substring(0, i) + str.substring(i+1);
            }
        }

        return str.substring(0, str.length() - 1);
    }

    // using stack
    // 维护一个递增栈，只要发现当前数字小于栈顶数字的话，就将栈顶元素移除
    public String removeKDigits_2(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top - 1] > c && k > 0) {
                top -= 1; // top - 1, 之后这个栈顶元素会被覆盖
                k -= 1;
            }
            stk[top++] = c;
        }

        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }

    public static void main(String[] args) {
        String num = "10";
        RemoveKDigits_402 test = new RemoveKDigits_402();
        System.out.println(test.removeKdigits(num, 1));
    }
}
