public class ShortestDistanceToCharacter_821 {
    public int[] shortestToChar(String S, char C) {
        int n = S.length(), pos = -n, res[] = new int[n];

        // 第一遍先看左边
        for (int i = 0;i < n;i++) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }

        // 第二遍看右边
        // pos - 1 就是最后一个c之前的元素，之后的元素就没必要看了
        for (int i = pos - 1;i >= 0;i--) {
            if (S.charAt(i) == C) pos = i;
            res[i] = Math.min(res[i], pos - i);
        }

        return res;
    }
}
