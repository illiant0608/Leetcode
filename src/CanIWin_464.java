import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin_464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<>());
    }

    private boolean canIWin(int total, int[] state, HashMap<String, Boolean> map) {
        String curr = Arrays.toString(state);
        if (map.containsKey(curr)) return map.get(curr);
        for (int i = 0;i < state.length;i++) {
            if (state[i] == 0) {
                state[i] = 1;
                if (total <= i+1 || !canIWin(total-(i+1), state, map)) {
                    map.put(curr, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }

        map.put(curr, false);
        return false;
    }
}
