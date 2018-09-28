public class ReverseString {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return sb.toString();
    }
}
