import java.util.HashMap;

/**
 * 将中文数字转化成阿拉伯数字
 */
public class ChineseNum {
    public int convert(String input) {
        String str1 = new String(), str2 = new String(), str3 = new String();
        int k = 0;
        boolean dealflag = true;

        for (int i = 0;i < input.length();i++){
            if ('零' == input.charAt(i))
                input = input.substring(0, i) + input.substring(i+1);
        }

        String chineseNum = input;
        for (int i = 0; i < chineseNum.length(); i++) {
            if (chineseNum.charAt(i) == '亿') {
                str1 = chineseNum.substring(0, i); // 亿前面的部分
                k = i+1;
                dealflag = false;
            }
            if (chineseNum.charAt(i) == '万') {
                str2 = chineseNum.substring(k, i);
                str3 = chineseNum.substring(i + 1);
                dealflag = false;
            }
        }

        if (dealflag) // 根本没有亿和万
            str3 = chineseNum;
        int result = sectionChinese(str1) * 100000000 +
                sectionChinese(str2) * 10000 + sectionChinese(str3);

        return result;

    }

    private int sectionChinese(String str) {
        int value = 0, sectionNum = 0;
        for (int i = 0; i < str.length(); i++) {
            int v = (int) Tool.intList.get(str.charAt(i));
            if (v == 10 || v == 100 || v == 1000) {
                sectionNum = v * sectionNum;
                value = value + sectionNum;
            } else if (i == str.length() - 1) {
                value = value + v;
            } else {
                sectionNum = v;
            }
        }

        return value;
    }
}

class Tool {
    public static String[] chnNumChar = {"零","一","二","三","四","五","六","七","八","九"};
    public static char[] chnNumChinese = {'零','一','二','三','四','五','六','七','八','九'};
    //节权位
    public static String[] chnUnitSection = {"","万","亿","万亿"};
    //权位
    public static String[] chnUnitChar = {"","十","百","千"};
    public static HashMap<Character, Integer> intList = new HashMap<>();
    static{
        for(int i=0;i<chnNumChar.length;i++){
            intList.put(chnNumChinese[i], i);
        }

        intList.put('十',10);
        intList.put('百',100);
        intList.put('千', 1000);
    }
}
