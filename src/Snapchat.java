import java.util.Arrays;


public class Snapchat {

  int findAmicableNum(int range) {
    int sum;
    int div;
    int chk;
    int n1, n2;
    int test = 0;
    while (++test < range) {
      sum = div = 0;
      while (++div <= test / 2) {
        if (test % div == 0)
          sum += div;
      }
      chk = sum;
      sum = div = 0;
      while (++div <= chk / 2) {
        if (chk % div == 0)
          sum += div;
      }
      if (sum == test) {
        if (test == chk)
          continue;
        n1 = test;
   //     if (n1 == n2)
   //       continue;
        n2 = chk;
      }
    }
    return 0;
  }

  class Node {
    Node left;
    Node right;
  }

  Node flattenBST(Node root) {
    if (root == null) return null;
    Node left = root.left;
    Node right = root.right;
    root.left = null;
    Node current = root;

    current.right = flattenBST(left);
    while (current.right != null)
      current = current.right;

    current.right = flattenBST(right);
    return root;
  }
  Node lastNode = null;
  public void flatten(Node root) {
    if (root == null) {
      return;
    }

    if (lastNode != null) {
      lastNode.left = null;
      lastNode.right = root;
    }

    lastNode = root;
    Node right = root.right;
    flatten(root.left);
    flatten(right);
  }

  //http://www.geeksforgeeks.org/archives/17401
  int count( int S[], int m, int n )
  {
     // table[i] will be storing the number of solutions for
     // value i. We need n+1 rows as the table is consturcted
     // in bottom up manner using the base case (n = 0)
     int[] table = new int[n+1];
     // Base case (If given value is 0)
     table[0] = 1;
     // Pick all coins one by one and update the table[] values
     // after the index greater than or equal to the value of the
     // picked coin
     for(int i=0; i<m; i++)
         for(int j=S[i]; j<=n; j++)
             table[j] += table[j-S[i]];

     return table[n];
  }

  int selectK(int[] list, int left, int right, int k) {
    if (left == right)
      return list[left];
    // select a pivotIndex between left and right, e.g. left + Math.floor(Math.random() * (right - left + 1))
    //int pivotIndex = left;
    int pivotIndex = partition(list, left, right);
    System.out.println("debug:"+Arrays.toString(list) + " index:" + pivotIndex);
    if (pivotIndex == k)
      return list[k];
    else if (k < pivotIndex)
      return selectK(list, left, pivotIndex-1, k);
    else
      return selectK(list, pivotIndex+1, right, k);
  }

  int partition(int[] list, int left, int right) {
    int pos = right;
    for(int index = right - 1; index >= left; index--)
    {
        if(list[index] > list[right])
            swap(list, --pos, index);
    }
    swap(list, pos, right);
    return pos;
  }

  private void swap(int[] list, int i, int j) {
    int tmp = list[i];
    list[i] = list[j];
    list[j] = tmp;

  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Snapchat s = new Snapchat();
    int[] list = {3,2,1,7,9,6};
    System.out.println(s.selectK(list, 0, 5, 1));
    System.out.println(Arrays.toString(list));
  }

}
