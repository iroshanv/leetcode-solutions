package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayArea_0 {


    public static void main(String[] args) {

        countMaximumProfitableGroups(List.of(2,3,2));
    }


    public static long countMaximumProfitableGroups(List<Integer> stockPrice) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int grpCounter = 1;
        for (int i = 0; i < stockPrice.size(); i++) {
            for (int j = i; j < stockPrice.size(); j++) {
                List<Integer> groups = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    groups.add(stockPrice.get(k));
                    map.put(grpCounter, groups);
                }
                grpCounter++;
            }
        }

        int noOfGroups = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();

            int maxProfit = 0;
            for (int i = 0; i < value.size(); i++) {
                if (value.get(i) > maxProfit) {
                    maxProfit = value.get(i);
                }
            }

            if (Math.max(value.get(value.size()-value.size()), value.get(value.size() - 1)) >= maxProfit) {
                noOfGroups++;
            }
        }

        return noOfGroups;
    }
}
