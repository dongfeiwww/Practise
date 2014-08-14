
public class EncodeNum {

  String encode(String src) {
    if (src == null || src.length() <=0) return null;
    int len = src.length();
    StringBuffer sb = new StringBuffer();
    int digitLen;
    for (int i=0; i<len; i++) {
      sb.append(src.charAt(i));
      digitLen = 1;
      while (i+1 < len && src.charAt(i) == src.charAt(i+1)) {
        digitLen++;
        i++;
      }
      sb.append(digitLen);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    EncodeNum e = new EncodeNum();
    System.out.println(e.encode("11122334"));
  }

}
