public class Palindrome_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder sb = new StringBuilder(x+"");
        if (sb.reverse().toString().equals(x + ""))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Palindrome_9 test = new Palindrome_9();
        test.isPalindrome(10);
    }
}
