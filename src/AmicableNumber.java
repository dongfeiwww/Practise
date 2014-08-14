import java.util.*;
public class AmicableNumber {
  class Pair {
    int first;
    int second;
    public Pair(int i, int j) {
      first = i;
      second = j;
    }
  }

  List<Pair> findAmicableParis(int A, int B) {
    List<Pair> result = new ArrayList<Pair>();

    Map<Integer, Integer> factorCache = new HashMap<Integer, Integer>();
    for (int i=A; i<=B; i++) {
      int sum = sumFactors(i);
      if (sum > B || sum < A) continue;
      if (factorCache.containsKey(sum) && factorCache.get(sum) == i) {
        result.add(new Pair(i, sum));
      } else {
        factorCache.put(i, sum);
      }
    }
    return result;
  }

  private boolean isAmicablePair(int first, int second) {
    int sumFirst = sumFactors(first);
    if (sumFirst != second)
      return false;

    int sumSecond = sumFactors(second);
    if (sumSecond != first)
      return false;
    return true;
  }

  private int sumFactors(int first) {
    int sum = 0;
    for (int i=1; i<=first/2; i++)
    {
      if (first%i==0)
        sum += i;
    }
    return sum;
  }

  public static void main(String[] args) {
    AmicableNumber a = new AmicableNumber();
  //  System.out.println(a.sumFactors(284));
  //  System.out.println(a.isAmicablePair(220, 284));
    List<Pair> list = a.findAmicableParis(1, 6000);
    for (Pair p: list) {
      System.out.println(p.first + " " + p.second);
    }

  }
}
