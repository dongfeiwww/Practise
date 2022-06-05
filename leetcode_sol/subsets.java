/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int k, ArrayList<ArrayList<Integer>> sets) {
        int n = sets.size();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> set = new ArrayList<Integer>(sets.get(i));
            set.add(S[k]);
            sets.add(set);
        }
        return sets;
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        sets.add(new ArrayList<Integer>());
        if (S.length == 0) {
            return sets;
        }
        for (int i = 0; i < S.length; i++) {
            subsets(S,i,sets);
        }
        return sets;
    }
}

// # nums = [1, 2, 3]
// def dfs(index):
//     if index == n: return [[]]

//     res = []
//     for subset in dfs(index+1):
//         res.append(subset)
//         res.append([nums[index]] + subset)
//     return res

// n = len(nums)
// return dfs(0)