import java.sql.SQLOutput;

/**
 * leetcode 696
 * 压缩字符串，简化问题
 */
public class CountingBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() <= 1) return 0;
        char[] arr = s.toCharArray();
        int[] iarr = new int[s.length()];
        int temp = 0;
        for (int i = 0;i < arr.length-1;i++) {
            iarr[temp]++;
            if (arr[i] != arr[i+1]) temp++;
        }
        if (arr[arr.length - 1] == arr[arr.length - 2])
            iarr[temp]++;
        else
            iarr[temp++] ++;

        int count = 0;
        for (int i = 0;i < iarr.length-1;i++) {
            if (iarr[i] != 0 && iarr[i+1] != 0)
                count += Math.min(iarr[i], iarr[i+1]);
        }



        return count;
    }


    public static void main(String[] args) {
        CountingBinarySubstrings test = new CountingBinarySubstrings();
        System.out.println(test.countBinarySubstrings("00110"));
    }
}
