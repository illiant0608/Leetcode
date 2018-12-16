public class ShiftingLetters_848 {
    public String shiftingLetters(String S, int[] shifts) {
        char[] s_chars = S.toCharArray();
        int shift = 0;
        for (int i = shifts.length - 1;i >= 0;i--) {
            shift = (shift + shifts[i]) % 26;
            s_chars[i] = (char) ((s_chars[i] - 'a' + shift) % 26 + 'a');
        }

        return new String(s_chars);
    }
}
