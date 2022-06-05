import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int current = 0;
        compute(num, target, current, temp, res, 0);

        return res;
    }

     Map<String, Integer> map = new HashMap<String, Integer>();

    public void compute(int[] candidates, int target, int current,
            ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int index) {
        if (current > target)
            return;

        if (current == target) {
            ArrayList<Integer> list = new ArrayList<Integer>(temp);
            java.util.Collections.sort(list);
            String sig = list.toString();
            if (!map.containsKey(sig)) {
                res.add(list);
                map.put(sig, 1);
            }

            return;
        }

        int len = candidates.length;
        for (int i = index; i < len; i++) {
            int value = candidates[i];
            temp.add(value);
            current += value;
            compute(candidates, target, current, temp, res, i+1);
            temp.remove(temp.size() - 1);
            current -= value;
        }
    }
}
