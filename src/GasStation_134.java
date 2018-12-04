public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //先找可能的开始位置
        for (int i = 0;i < gas.length;i++) {
            if (gas[i] >= cost[i]) {
                //可以从这里开始
                int rest_gas = gas[i] - cost[i];
                boolean ok_flag = true;
                for (int j = (i+1) % gas.length;j != i;j = (j+1) % gas.length) {
                    rest_gas += gas[j];
                    rest_gas -= cost[j];

                    if (rest_gas < 0) {
                        ok_flag = false;
                        break;
                    }

                }
                if (ok_flag)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        GasStation_134 test = new GasStation_134();
        int[] gas = {2};
        int[] cost = {2};

        System.out.println(test.canCompleteCircuit(gas, cost));
    }
}
