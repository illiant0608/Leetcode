import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);
        int dist = 1;

        while (!visited.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for (String word : visited) {
                for (int i = 0; i < word.length(); ++i) {
                    char[] chars = word.toCharArray();
                    for (int j = (int) 'a'; j < (int) 'z' + 1; j++) {
                        chars[i] = (char) j;
                        String neWord = new String(chars);
                        if (wordSet.contains(neWord)) {
                            temp.add(neWord);
                            wordSet.remove(neWord);
                        }
                    }
                }
            }

            dist += 1;
            if (temp.size() == 0)
                return 0;

            visited = temp;
        }

        return dist;
    }




}
