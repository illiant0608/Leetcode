import java.util.HashMap;
import java.util.Map;

class PigKind {
    int small;
    int big;
    HashMap<Integer, Integer> pigs = new HashMap<>();

    public PigKind(int small, int big) {
        this.small = small;
        this.big = big;
    }


}

public class Pig {

    public static void main(String[] args) {
        int year = 2019;
        HashMap<Integer, Integer> pigs = new HashMap<>();
        pigs.put(2, 1);
        pigs.put(3, 3);

        int pigNum = 3;

        while (year <= 2030) {
            int pigtobirth = inc(pigs);
            for (int i = 0;i < pigtobirth;i++) {
                pigs.put(getId(pigNum), 1);
                pigNum++;
            }
            System.out.println(year + " : " + pigtobirth);
            year++;
        }
    }

    public static int getId(int num) {
        if (num == 1) return 2;
        else if (num == 2) return 3;
        else if (num == 3) return 4;
        else return getId(num - 2) + getId(num - 3);
    }

    public static int inc(HashMap<Integer, Integer> map) {
        int pigtobirth = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= 3)
                pigtobirth++;
            e.setValue(e.getValue() + 1);
        }

        return pigtobirth;
    }
}
