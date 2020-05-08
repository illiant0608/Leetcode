public class RandomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr1 = new int[26];
        for (int i = 0;i < magazine.length();i++)
            arr1[magazine.charAt(i) - 'a']++;

        for (int i = 0;i < ransomNote.length();i++) {
            if (--arr1[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
