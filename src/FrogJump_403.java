import java.util.*;

public class FrogJump_403 {
    public boolean canCross(int[] stones) {

        if (stones.length == 0) return true;

        // key代表青蛙站的位置，value代表在这个位置，青蛙能跳几步(多种跳法)
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(1);

        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }

        for (int i = 0; i < stones.length - 1;i ++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1])
                    return true;

                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }


    // 超时递归算法
    public boolean cross(List<Integer> stones, int pos, int k) {
        System.out.println("at position: " + pos + " k: " + k);
        if (pos >= stones.size()) return false;
        if (pos == stones.size() - 1) return true;

        if (pos == 0) {
            // 如果是在第一块石头，first jump must be 1
            if (stones.get(1) != 1) return false;
            return cross(stones, 1, 1);
        }

        int dis = stones.get(pos + 1) - stones.get(pos);
        if (dis > k + 1) return false;

        int cur_unit = stones.get(pos);
        boolean result = false;
        if (k > 1 && stones.contains(cur_unit + k - 1)) {
            result = result || cross(stones, stones.indexOf(cur_unit + k - 1), k - 1);
            if (result) return true;
        }
        if (k >= 1 && stones.contains(cur_unit + k)) {
            result = result || cross(stones, stones.indexOf(cur_unit + k), k);
            if (result) return true;
        }
        if (stones.contains(cur_unit + k + 1)) {
            result = result || cross(stones, stones.indexOf(cur_unit + k + 1), k + 1);
            if (result) return true;
        }

        return result;
    }


    Map<String, Boolean> result_map = new HashMap<>();
    public boolean cross(int[] stones, int pos, int k) {
        String key = "pos" + pos + "k" + k;
        if(result_map.containsKey(key)) return result_map.get(key);

        for (int i = pos + 1; i < stones.length; i++)
        {
            int gap = stones[i] - stones[pos];
            if (gap < k - 1) continue;
            if (gap > k + 1)
            {
                result_map.put(key, false);
                return false;
            }

            // 如果能reach，下一个递归的pos就是i，跳跃距离就是gap大小
            if (cross(stones, i, gap))
            {
                // 用map存下结果，避免重复计算
                result_map.put(key, true);
                return true;
            }
        }

        // 能达到最后一个元素就是true
        result_map.put(key, pos == stones.length - 1);
        return result_map.get(key);
    }

    public static void main(String[] args) {
        int[] array = {0,1,3,5,6,8,12,17};

        FrogJump_403 test = new FrogJump_403();

        System.out.println(test.canCross(array));
    }
}
