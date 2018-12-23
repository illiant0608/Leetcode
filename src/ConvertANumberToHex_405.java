public class ConvertANumberToHex_405 {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();

        if (num == 0) return sb.append(0).toString();
        int sign = 1;
        int bitNum = 8;

        if (num < 0) {
            sign = -1;
            num = - num - 1;
        }

        while (sign == 1 && num != 0) {
            int mod = num % 16;
            if (mod < 10) {
                sb.append(mod);
            } else {
                sb.append((char) ('a' + mod - 10));
            }

            num /= 16;
        }

        while (sign == -1 && bitNum > 0) {
            int mod = num % 16;
            if (mod < 6) {
                sb.append((char) ('f' - mod));
            } else {
                sb.append(15 - mod);
            }

            num /= 16;
            bitNum--;
        }

        return sb.reverse().toString();


//        if(num == 0) return "0";
//        String result = "";
//        while(num != 0){
//            result = map[(num & 15)] + result;
//            num = (num >>> 4);
//        }
//        return result;

    }
}
