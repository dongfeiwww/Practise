public class Solution {
  public ArrayList<String> restoreIpAddresses(String s) {
    ArrayList<String> ret=new ArrayList<String>();
    int[] end=new int[4];
    dfs(ret,end,s,0,0,4);
    return ret;
  }

  public void dfs(ArrayList<String> ret,int[] end,String s,int beg,int dep,int maxDep){
    if(dep==maxDep){
      if(beg==s.length()){
        int start=0;
        String cur="";
        for(int i=0;i<maxDep;i++){
          String temp=s.substring(start,end[i]+1);
          cur +=i==0?temp:"."+temp;
          start=end[i]+1;
        }
        ret.add(cur);
      }
      return;
    }
    for(int i=beg;i<s.length();i++){
      if(check(s,beg,i)){
        end[dep]=i;
        dfs(ret,end,s,i+1,dep+1,maxDep);
      }
    }
  }
  
  public boolean check(String s,int beg,int end){
    String temp=s.substring(beg,end+1);
    if(temp.length()==1) return temp.compareTo("0")>=0&&temp.compareTo("9")<=0;
    else if(temp.length()==2) return temp.compareTo("10")>=0&&temp.compareTo("99")<=0;
    else if(temp.length()==3) return temp.compareTo("100")>=0&&temp.compareTo("255")<=0;
    return false;
  }
}
