package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayArea_1 {


    public static void main(String[] args) {
        findMinimumNumberOfPages(List.of(2,4,3), 4);
    }


    public static int findMinimumNumberOfPages(List<Integer> pages, int days) {

        int noOfDays = 0;
        for (Integer page:
             pages) {

            if (page > days) {
                noOfDays++;
            }


        }


        return 1;
    }
}
