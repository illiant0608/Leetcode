import java.util.LinkedList;
import java.util.Queue;

public class LongestSubWithoutRepeating_3 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) //如果有相同的字符
                queue.poll(); //就把队列中的第一个删掉，直到没有重复
            queue.offer(c);
            res = Math.max(res, queue.size());
        }

        return res;
    }
}
