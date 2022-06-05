/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations. For example, [1,1,2] have the following unique permutations: [1,1,2], [1,2,1], and [2,1,1].
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length<=0) return result;
        Arrays.sort(num);
        ArrayList<Integer> res=new ArrayList<Integer>();
        boolean[] used=new boolean[num.length];
        for(int i=0;i<used.length;i++) used[i]=false;
        dfs(result,res,num,used,num.length);
        return result;
    }
    public void dfs(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> res,int[] num,boolean[] used,int n){
        if(n==0){
            ArrayList<Integer> cur=new ArrayList<Integer>();
            for(int i=0;i<res.size();i++) cur.add(res.get(i));
            result.add(cur);
            return;
        }
        for(int i=0;i<used.length;i++){
            if(used[i]==true||(i!=0&&num[i]==num[i-1]&&used[i-1]==true))
                continue;
            used[i]=true;
            res.add(num[i]);
            dfs(result,res,num,used,n-1);
            res.remove(res.size()-1);
            used[i]=false;
        }
    }
}
