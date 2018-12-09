public class StringCompression_443 {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length) {
            char currentchar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentchar) {
                index++;
                count++;
            }

            chars[indexAns++] = currentchar;
            if (count != 1)
                for (char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}
