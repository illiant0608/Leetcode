import javafx.util.Pair;

import java.util.*;
public class MostProfitAssigningWork_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0;i < difficulty.length;i++) {
            //可能会有key重复，这个时候要选profit更高的值
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

//        for (Map.Entry<Integer, Integer> mapping : list)
//            System.out.println(mapping.getKey() + ":" + mapping.getValue());

         for (int i = 0;i < worker.length;i++) {
             int ability = worker[i];
             for (Map.Entry<Integer, Integer> mapping : list) {
                 if (mapping.getKey() <= ability) {
                     //可以干这个工作
                     System.out.println(ability + ":" + mapping.getKey() + ":" + mapping.getValue());
                     sum += mapping.getValue();
                     break;
                 }
             }
         }

         return sum;

//        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
//        int N = profit.length, res = 0, i = 0, maxp = 0;
//        for (int j = 0; j < N; j++) jobs.add(new Pair<>(difficulty[j], profit[j]));
//        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
//        Arrays.sort(worker);
//        for (int ability : worker) {
//            while (i < N && ability >= jobs.get(i).getKey())
//                maxp = Math.max(jobs.get(i++).getValue(), maxp);
//            int tmp = i-1;
//            System.out.println(ability + ":" + maxp) ;
//            res += maxp;
//        }
//        return res;

    }

    public static void main(String[] args) {
        int[] diff =   {66,1, 28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
        int[] profit = {66,20,84,81,56,40,37,82,53, 45,43,96,67,27,12,54,98,19,47,77};
        int[] worker = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};

        MostProfitAssigningWork_826 test =new MostProfitAssigningWork_826();
        System.out.println(test.maxProfitAssignment(diff, profit, worker));
    }
}
