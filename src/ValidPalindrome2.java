import java.util.Arrays;
import java.util.HashSet;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        char[] chs= s.toCharArray();
        int l=0, h= chs.length-1;
        while(l<h){
            /* if chs[left] != chs[right] we can either skip the left or skip the right and try again*/
            if(chs[l]!=chs[h]) return vadlidation(chs, l+1, h)  || vadlidation(chs, l, h-1);
            ++l; --h;
        }
        return true;
    }
    boolean vadlidation(char[] chs, int l, int h){
        while(l<h){
            if(chs[l]!=chs[h]) return false;
            ++l; --h;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        ValidPalindrome2 test = new ValidPalindrome2();
        test.validPalindrome(s);
    }
}
