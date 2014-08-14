
public class PrintDigonal {
  static void print(char[][] a) {
    if (a == null || a.length <=0) return;
    int len = a.length;
    
    for (int i=0; i<4; i++) {
      for (int j=0; i+j<4; j++)
        System.out.print(a[j][i]);
      System.out.println();
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    char[][] array = new char[4][4];
    for (int i=0; i<16; i++)
      array[i/4][i%4] = (char) ('a' + i);
    print(array);
  }

}
