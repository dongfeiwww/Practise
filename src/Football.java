import java.util.*;
public class Football {
  static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

  static int  numWays(int[] input, int target) {
    if (target < 0)
      return 0;
    if (target == 0)
      return 1;

    if (cache.containsKey(target)) return cache.get(target);

    int total = 0;
    for (int i =0; i<input.length; i++) {
      total += numWays(input, target-input[i]);
    }

    cache.put(target, total);
    return total;
  }

  static int  numWays2(int[] input, int target) {
    int[] totals = new int[target+1];
    totals[0] =1;
    for (int i=0; i<input.length; i++) {
      for (int j=input[i]; j<=target; j++) {
        totals[j] += totals[j-input[i]];
        System.out.println("totals["+j+"]" + totals[j] + " totals["+(j-input[i])+"]:" + totals[j-input[i]]);
      }
    }
    //System.out.println("totals[3]" + totals[3] + " totals[2]:" + totals[2]);
    return totals[target];
  }

  public static void main(String[] args) {
    int[] input = {2,3,7};
    System.out.println(numWays2(input, 7));
  //  System.out.println(numWays2(input, 4));
  //  System.out.println(numWays2(input, 5));
  //  System.out.println(numWays2(input, 6));
  }
}
