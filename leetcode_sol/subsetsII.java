/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
/*
 * Implemented based DFS + backtrack
 */
public class Solution{
public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    if (S == null || S.length == 0) return list;
    Arrays.sort(S);
    for (int i=0; i<=S.length; i++){
        dfs(S, 0, new int[i], 0, list);
    }
    return list;
}
 
void dfs(int[] S, int si, int[] T, int ti, ArrayList<ArrayList<Integer>> list){
    if (ti == T.length){
        ArrayList<Integer> sol = new ArrayList<Integer>();
        for (int i=0; i<ti; i++)
            sol.add(T[i]);
        list.add(sol);
        return;
    }
    for (int i = si; i<S.length; i++){
        T[ti] = S[i];
        dfs(S, i+1, T, ti+1, list);
    }
}
 
/*
 * Iterative version I : based on bit permutation
 */
public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    if (S == null || S.length == 0) return list;
    Arrays.sort(S);
    int n = S.length, maxn = 1 << n;
    for (int i=0; i<maxn; i++){
        ArrayList<Integer> sol = new ArrayList<Integer>();
        int key = i;
        for (int j=0; j<n; j++){
            if ((key & 1) != 0)
                sol.add(S[j]);
            key >>= 1;
        }
        list.add(sol);
    }
    return list;
}
 
/*
 * Iterative version II : based on adding each element to all subset increamentally.
 */
public ArrayList<ArrayList<Integer>> subsets(int[] S){
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
  if (S == null || S.length == 0) return list;
  list.add(new ArrayList<Integer>());
  for (int i=0; i<S.length; i++){
    int size = list.size();
    for (int j = 0; j < size; j++){
      ArrayList<Integer> sol = new ArrayList<Integer>(list.get(j));
      sol.add(S[i]);
      list.add(sol);
    }
  }
  return list;
}
} 
