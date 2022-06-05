/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters. For example, given: S: "barfoothefoobarman" L: ["foo", "bar"] You should return the indices: [0,9]. (order does not matter).
*/
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret=new ArrayList<Integer>();
        if(L.length<1||S.length()<L.length*L[0].length()) return ret;
        Map<String ,Integer> count=new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++){
            if(count.containsKey(L[i])) count.put(L[i],count.get(L[i])+1);
            else count.put(L[i],1);
        }
        int i=0;
        int sLen=S.length();
        int lLen=L.length;
        int wLen=L[0].length();
        while(i<=sLen-lLen*wLen){
            Map<String,Integer> temp=new HashMap<String,Integer>(count);
            for(int j=0;j<lLen;j++){
                String s=S.substring(i+j*wLen,i+(j+1)*wLen);
                if(temp.containsKey(s)){
                    if(temp.get(s)>1) temp.put(s,temp.get(s)-1);
                    else temp.remove(s);
                }else break;
            }
            if(temp.isEmpty()) ret.add(i);
            i++;
        } 
        return ret;
    }
}
