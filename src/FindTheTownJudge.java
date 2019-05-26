/**
 * leetcode 997
 */
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        // 先找不信任任何人的人
        int[] arr = new int[N];
        for(int i = 0;i < trust.length;i++) {
            arr[trust[i][0] - 1]++;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                // 再判断他是不是被所有人信任
                if (helper(i+1, trust, N))
                    return i+1;
            }
        }

        return -1;
    }

    public boolean helper(int num, int[][] trust, int N) {
        int[] all_people = new int[N];

        for(int[] arr : trust) {
            if (arr[1] == num)
                all_people[arr[0]-1]++;
        }

        for (int i = 0; i < all_people.length; i++) {
            if (all_people[i] == 0 && i != num - 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 2;
        int[][] trust = {{1,2}};
        FindTheTownJudge test = new FindTheTownJudge();
        System.out.println(test.findJudge(2, trust));
    }
}
