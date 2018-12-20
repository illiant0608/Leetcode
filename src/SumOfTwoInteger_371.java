public class SumOfTwoInteger_371 {
    public int getSum(int a, int b) {
        int result = a ^ b; //代表结果
        int carry = (a & b) << 1; //代表进位
        if (carry != 0) return getSum(result, carry); // 如果结果加进位又有进位，就递归调用到没有进位
        return result;
    }

    public static void main(String[] args) {
        SumOfTwoInteger_371 tst =new SumOfTwoInteger_371();
        System.out.println(tst.getSum(1,2));
    }
}
