
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        list.add(row);
        if (numRows == 1) {
            return list;
        }
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        list.add(row);
        if (numRows == 2) {
            return list;
        }
        for (int i = 2; i < numRows; i++) {
            row = new ArrayList<>();
            row.add(1);
            for (int col = 0; col < i - 1; col++) {
                int num = list.get(i - 1).get(col) + list.get(i - 1).get(col + 1);
                row.add(num);
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
