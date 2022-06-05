import java.util.*;

public class SnippetWindow {

  String findMinWindow(String s, Set<Character> targets) {
    HashMap<Character, Integer> posMap = new HashMap<Character, Integer>();
    int index = 0;
    int len = s.length();
    int minWindow = len + 1;
    String res = new String();
    while (true) {
      while (posMap.size() < targets.size() && index<len) {
        char c = s.charAt(index);
        if (targets.contains(c))
          posMap.put(c, index);
        index++;
      }

      if (index >= len)
        break;

      int max = max(posMap.values());
      int min = min(posMap.values());
      int current = max - min;
      if (current < minWindow) {
        System.out.println("debug:minWindow:" + minWindow + " max:" + max + " min:" + min);
        minWindow = current;
        res = s.substring(min, max + 1);
      }
      posMap.remove(s.charAt(min));
    }
    return res;
  }

  int min(Collection<Integer> values) {
    int min = 1000;
    for (Integer v: values) {
      if (min > v)
        min = v;
    }
    return min;
  }

  int max(Collection<Integer> values) {
    int max = -1;
    for (Integer v: values) {
      if (max < v)
        max = v;
    }
    return max;
  }

  public static void main(String[] args) {
    SnippetWindow window = new SnippetWindow();
    Set<Character> targets = new HashSet<Character>();
    targets.add('A');
    targets.add('B');
   // targets.add('C');
    System.out.println(window.findMinWindow("AAAEBDCAB", targets));
    System.out.println(window.findMinWindow("CAEBADCA", targets));
  }
}
