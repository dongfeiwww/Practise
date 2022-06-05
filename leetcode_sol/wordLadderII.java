public class Solution {
  public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<String>> results=new ArrayList<ArrayList<String>>(); 
    if(start.length()!=end.length()) return results; 
    Queue<ArrayList<String>> que=new LinkedList<ArrayList<String>>();
    ArrayList<String> list=new ArrayList<String>(); 
    list.add(start);
    que.add(list);
    int distance=1; 
    int currentNum=0; 
    int nextNum=0; 
    while(!que.isEmpty() && dict.size()>0)
    {
      ArrayList<String> currentList=que.poll(); 
      currentNum--; 
      String current=currentList.get(currentList.size()-1);
      for(int i=0; i<current.length(); i++)
      {
        for(char j='a'; j<='z'; j++)
        {
          if(current.charAt(i)==j) continue; 
          String temp=current.substring(0, i)+j+(i!=current.length()-1? current.substring(i+1):"");
          if(temp.equals(end))
          {
            currentList.add(end);
            results.add(currentList);
          } 
          if(dict.contains(temp))
          {
            ArrayList<String> anotherList=(ArrayList<String>)currentList.clone(); 
            anotherList.add(temp);
            que.add(anotherList);
            nextNum++; 
          }
        }
      }              
      if(currentNum<=0)
      {
        if(results.size()!=0) return results; 
        currentNum=nextNum; 
        distance++; 
        nextNum=0; 
      }
    }
    return 0; 
  }
}
