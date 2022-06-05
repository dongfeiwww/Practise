/* You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
    public void rotate(int[][] m) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j;
        int n = m.length;
        // first mirror the matrix along the diagnal line.
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }   
        }   

        // mirror the matrix horizontally.
        for (i = 0; i < n / 2; i++) {
            for (j = 0; j < n; j++) {
                int tmp = m[j][i];
                m[j][i] = m[j][n - i - 1]; 
                m[j][n - i - 1] = tmp;
            }   
        }
    }
}
