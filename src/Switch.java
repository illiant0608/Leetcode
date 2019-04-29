public class Switch {
    public static void main(String[] args) {
        int a = 5, b = 7;
        a = a ^ b;
        b = b ^ a; //  b ^ a ^ b = a
        a = a ^ b; // a ^ b ^ a = b
        System.out.println(a + " : " + b);

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " : " + b);
    }
}
