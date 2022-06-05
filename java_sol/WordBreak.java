import java.util.*;

public class WordBreak {
  public int minWordBreak(String s, Set<String> dict) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    List<String> possibles = wordBreakHelper(s,dict,map);
    int minCut = s.length();
    for (String possible: possibles) {
      int cut = possible.split(" ").length;
      if (minCut > cut)
        minCut = cut;
    }
    return minCut;
}

  public List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> memo){
    if(memo.containsKey(s)) return memo.get(s);
    List<String> result = new ArrayList<String>();
    int n = s.length();
    if(n <= 0) return result;

    for(int len = 1; len <= n; ++len){
        String prefix = s.substring(0,len);
        if(dict.contains(prefix)){
            if (len == n){
                result.add(prefix);
            } else {
                String postfix = s.substring(len);
                List<String> remindings = wordBreakHelper(postfix, dict, memo);
                for (String item : remindings) {
                    item = prefix + " " + item;
                    result.add(item);
                }
            }
        }
    }

    memo.put(s, result);
    return result;
  }

//  public int wordBreakHelper2(String s, Set<String> dict, Map<String, Integer> memo){
//    if(memo.containsKey(s)) return memo.get(s);
//    int n = s.length();
//    if(n <= 0) return 0;
//
//    int min = 0;
//    for(int len = 1; len <= n; ++len){
//        String prefix = s.substring(0,len);
//        if(dict.contains(prefix)){
//            if (len == n){
//                result.add(prefix);
//            } else {
//                String postfix = s.substring(len);
//                List<String> remindings = wordBreakHelper2(postfix, dict, memo);
//                for (String item : remindings) {
//                    item = prefix + " " + item;
//                    result.add(item);
//                }
//            }
//        }
//    }
//
//    memo.put(s, result);
//    return result;
//  }
}
