// JAVA Code for Zigzag (or diagonal) 
// traversal of Matrix

class GFG{
	
	public static int R,C;
	
	private static  void diagonalOrder(int matrix[][]) {
	    int total = R + C -1;
	    int flag = 1;
	    int num = 0;
	    for (int i=0; i< total; i++) {
    		if (num >= C) {
    			flag = -1;
    		}
    		num = flag>0? num+1: num-1;
    		for (int j = 0; j < num; j++) {
    			int cal_row = Math.min(i, R-1) - j;
    			
    			System.out.print(matrix[cal_row][i-cal_row] + " ");
    		}
    		System.out.println();
	    }  
    }
	
		// driver program to test above function
		public static void main(String[] args) {
			int arr[][] = { {1, 2, 3, 4},
							{5, 6, 7, 8},
							{9, 10, 11, 12},
							{13, 14, 15, 16}, };
			
			R=arr.length;
			C=arr[0].length;
			
			diagonalOrder(arr);
		}
}

