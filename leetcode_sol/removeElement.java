/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0, j = A.length - 1;
        while (i <= j) {
            if (A[i] == elem) {
                if (A[j] == elem) {
                    j--; 
                } else {
                    A[i] = A[j];
                    i++;
                    j--; 
                }   
            } else {
                i++;
            }   
        }   
        return i;
    }
}

public class Solution {
    public int removeElement(int[] A, int elem) {
        int index=0;
        for(int i=0;i<A.length;i++)
            if(A[i]!=elem)
                A[index++]=A[i];
        return index;
    }
}
