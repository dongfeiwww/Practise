// Given a number represented as an array of digits, plus one to the number.
// math
public class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> sum = new Stack<Integer>();
        int plusNumber=1;
        for(int i=digits.length-1; i>=0; i--){
            int cur = digits[i]+plusNumber;
            sum.push(cur%10);
            plusNumber= cur>=10? 1:0;
        }
        int[] result;

        if(plusNumber==1){
            sum.push(1);
            result=new int[digits.length+1];
            
        } else {
            result=new int[digits.length];
        }

        for(int i=0;i<result.length;i++) {
            result[i] = sum.peek();
            sum.pop();
        }

        return result;
    }
}
