//http://blog.csdn.net/kenby/article/details/6833407
/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
public class Solution {
  public double findMedianSortedArrays(int A[], int B[]) {
    int k=A.length+B.length;
    if(k%2==1) return findKth(A,A.length,B,B.length,k/2+1);
    else return (findKth(A,A.length,B,B.length,k/2)+findKth(A,A.length,B,B.length,k/2+1))/2;
  }

  public double findKth(int A[],int m,int B[],int n,int k){
    if(m>n) return findKth(B,n,A,m,k);
    if(m==0) return B[k-1];
    if(k<=1) return Math.min(A[0],B[0]);
    int pa=Math.min(k/2,m);
    int pb=k-pa;
    if(A[pa-1]<B[pb-1]) return findKth(Arrays.copyOfRange(A,pa,m),m-pa,B,n,k-pa);
    else if(A[pa-1]>B[pb-1]) return findKth(A,m,Arrays.copyOfRange(B,pb,n),n-pb,k-pb);
    else return A[pa-1];
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int findMedian(int A[], int B[], int m, int n, int s, int t) {
        int p, c;
        c = (m + n - 1) / 2;
        p = (s + t) / 2;
        if (s > t)
            return findMedian(B, A, n, m, 0, n - 1);

        if (A[p] >= B[c - p - 1] && A[p] <= B[c - p])
            return A[p];
        if (A[p] < B[c - p - 1])
            return findMedian(A, B, m, n, p + 1, t);
        return findMedian(A, B, m, n, s, p - 1);
    }

    public static int findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        if (lenA < 1)
            return lenB % 2 == 0 ? B[lenB / 2 - 1] : B[lenB / 2];
        if (lenB < 1)
            return lenA % 2 == 0 ? A[lenA / 2 - 1] : A[lenA / 2];
        return findMedian(A, B, lenA, lenB, 0, lenA - 1);
    }

    static int[] parse(String line) {
        String[] sarray = line.split(",");
        int[] intarray = new int[sarray.length];
        for (int i = 0; i < sarray.length; i++) 
            intarray[i] = Integer.parseInt(sarray[i]);
        return intarray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = parse(br.readLine());
        int[] B = parse(br.readLine());
        System.out.println(findMedianSortedArrays(A, B));
    }
}

public class Solution {
    public double findMedian(int A[], int l1, int r1, int B[], int l2,int r2){
        int mid1,mid2;
        if( (r1-l1+1)%2==0 ) {
            mid1=(l1+r1)/2+1;
            mid2=(l2+r2)/2;
        }
        else {
            mid1=(l1+r1)/2;
            mid2=(l2+r2)/2;
        }

        if(l1==r1 && l2==r2)
            return (double)(A[l1]+B[l2])/2;

        if(r1-l1==1 && r2-l2==1 ) {
            if(A[mid1]>B[mid2]) {
                if(B[r2]<=A[l1])
                    return (double)(B[r2]+A[l1])/2;
                else if(A[l1]<=B[mid2] && A[mid1]>=B[r2])
                    return (double)(B[mid2]+A[mid1])/2;
                else if(A[l1]<=B[mid2] && A[mid1]<B[r2])
                    return (double)(B[mid2]+B[r2])/2;
            }
        }

        if(A[mid1]==B[mid2])
            return A[mid1];
        else if( A[mid1] > B[mid2])
            return findMedian(A,l1,mid1,B,mid2,r2);
        else
            return findMedian(A,mid1,r1,B,l2,mid2);
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        if (lenA < 1) {
            if (lenB % 2 == 0) {
                return (double)(B[lenB/2] + B[lenB/2 -1])/2;
            } else
                return B[lenB/2];
        }
        if (lenB < 1) {
            if (lenA % 2 == 0) {
                return (double)(A[lenA/2] + A[lenA/2 -1])/2;
            } else
                return A[lenA/2];
        }
        return findMedian(A, 0, lenA, B, 0, lenB);
    }
}
