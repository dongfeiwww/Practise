
public class Solution {

    String add(String s1, String s2) {
        StringBuffer sb = new StringBuffer();

        int carrier = 0;
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int a = 0;
            int b = 0;

            if (p1 >= 0) {
                a = s1.charAt(p1) - '0';
                p1--;
            }

            if (p2 >= 0) {
                b = s2.charAt(p2) - '0';
                p2--;
            }
            sb.append((a + b + carrier) % 10);
            carrier = (a + b + carrier) / 10;
        }

        return sb.reverse().toString();
    }
    
    String mul(String a, int c, int b) {
        StringBuffer sb = new StringBuffer();
        int carrier = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int t = (a.charAt(i) - '0') * c;
            sb.append((t + carrier) % 10);
            carrier = (t + carrier) / 10; 
        }   

        sb.reverse();
        for (int i = 0; i < b; i++)
            sb.append(0);

        return sb.toString();
    }
    
    public String multiply(String num1, String num2) {
        String result = ""; 
        for (int i = 0; i < num2.length(); i++) {
            result = add(result, mul(num1, num2.charAt(num2.length() - 1 - i) - '0', 
i));
        }   

        return result;
    }
}
