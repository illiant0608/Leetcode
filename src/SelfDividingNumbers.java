import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left;i <= right;i++) {
            if (isSelfDivingNumber(i))
                list.add(i);
        }

        return list;
    }

    boolean isSelfDivingNumber(int number) {
        if (number >= 1 && number <= 9)
            return true;
        String numString = number+"";
        if (numString.contains("0"))
            return false;

        char[] arr = numString.toCharArray();
        for (int i = 0;i < arr.length;i++) {
            if (number % (arr[i] - '0') != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers test = new SelfDividingNumbers();
        test.selfDividingNumbers(1, 22);
    }
}
