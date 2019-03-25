import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Editor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int num = in.nextInt();
//        for (int i = 0;i < num;i++) {
//            System.out.println(editor(in.next()));
//        }
        System.out.println(editor("helloo"));

    }

    public static String editor(String str) {
        List<Character> arr = new ArrayList<>(str.length());
        for (int i = 0;i < str.length();i++)
            arr.add(str.charAt(i));


        for (int i = 0;i < arr.size() - 3;i++) {
            while (arr.get(i) == arr.get(i+1) && arr.get(i) == arr.get(i+2))
                arr.remove(i+2);
        }

        for (int i = 0;i <= arr.size() - 4;i++) {
            if (arr.get(i) == arr.get(i+1) && arr.get(i+2) == arr.get(i+3))
                arr.remove(i+3);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }

//    String s1 = String.valueOf(arr.get(i));
//    String s2 = String.valueOf(arr.get(i+1));
//    String s3 = String.valueOf(arr.get(i+2));
//    String s4 = String.valueOf(arr.get(i+3));
//            System.out.println(s1+s2+s3+s4);
}