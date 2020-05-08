import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveCoveredIntervals_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dis1 = o1[1] - o1[0];
                int dis2 = o2[1] - o2[0];
                if (dis1 < dis2) return -1;
                else if (dis1 > dis2) return 1;
                else return 0;
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[intervals.length - 1]);
        for (int i = 0; i < intervals.length - 1;i++) {
            boolean should_add_to_list = true;
            for (int j = i + 1;j < intervals.length;j++) {
                int[] interval1 = intervals[i];
                int[] interval2 = intervals[j];

                if (interval1[0] >= interval2[0] && interval1[1] <= interval2[1]) {
                    should_add_to_list = false;
                    break;
                }
            }

            if (should_add_to_list) list.add(intervals[i]);
        }

        return list.size();
    }

    public int sort_solution(int[][] intervals) {
        int res = 0, left = -1, right = -1; // 将边界记录下来，一旦超出了边界，就意味着 + 1
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] v : intervals) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {2, 8}, {3, 6}};

        RemoveCoveredIntervals_1288 test = new RemoveCoveredIntervals_1288();
        System.out.println(test.removeCoveredIntervals(intervals));
    }
}
