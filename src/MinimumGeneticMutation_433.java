import java.util.*;

public class MinimumGeneticMutation_433 {
    private int min = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>();
        for (String b : bank) bankSet.add(b);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;

                char[] currArray = curr.toCharArray();
                for (int i = 0;i < currArray.length;i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (!visited.contains(next) && bankSet.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }

        return -1;
    }

    public void backtracking(String start, String end, String[] bank, boolean[] marked, int n) {
        if (start.equals(end)) {
            min = Math.min(min, n);
            return;
        }

        for (int i = 0;i < bank.length;i++) {
            if (!marked[i] && getDistance(start, bank[i]) == 1) {
                marked[i] = true;
                backtracking(bank[i], end, bank, marked, n + 1);
                marked[i] = false;
            }
        }
    }

    public int getDistance(String s1, String s2) {
        int dis = 0;
        for (int i = 0;i < 8;i++)
            if (s1.charAt(i) != s2.charAt(i))
                dis++;
        return dis;
    }

    public static void main(String[] args) {
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        MinimumGeneticMutation_433 test = new MinimumGeneticMutation_433();
        System.out.println(test.minMutation("AACCGGTT", "AAACGGTA", bank));
    }
}
