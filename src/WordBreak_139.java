

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] breakable = new boolean[s.length() + 1]; // breakable[i] 表示范围[0, i)内的子串是否可以拆分，长度大1是为了处理空串的情况
        breakable[0] = true;

        for (int i = 1;i <= s.length();i++) {
            for (int j = 0;j < i;j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) { //位置j能够break，而且从j到i的单词存在于wordDict中
                    breakable[i] = true;
                    break;
                }
            }
        }

        return breakable[s.length()];
    }

//    private MyPair contains (String s, String word) {
//        int wordlen = word.length();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0;i < s.length() - wordlen + 1;i++) {
//            String tmp = s.substring(i, i + wordlen);
//            if (tmp.equals(word)) {
//                return new MyPair(i, i+wordlen);
//            }
//        }
//        return new MyPair(-1, -1);
//    }
//
//    class MyPair {
//        int first;
//        int second;
//        public MyPair(int first, int second) {
//            this.first = first;
//            this.second = second;
//        }
//
//        public int getFirst() {
//            return first;
//        }
//
//        public int getSecond() {
//            return second;
//        }
//    }


    public static void main(String[] args) {
        String s = "bb";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");

        WordBreak_139 test = new WordBreak_139();
//        Pair<Integer, Integer> pair = test.contains(s, "code");
//        System.out.println(pair.getKey());
        System.out.println(test.wordBreak(s, wordDict));
    }
}
