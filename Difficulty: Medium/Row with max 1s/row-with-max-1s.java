//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public  int solverawcount(int arr[] , int x ) {
        int low = 0 ;
        int n = arr.length ;
        int high = n -1 ;
        int ans = n ; 
        while(low <= high) {
            int mid = low+(high-low) /2 ;
            if(arr[mid] >= x) {
                ans = mid ;
                high = mid -1 ;
            }
            else {
                low = mid + 1 ;
            }
        }
        return ans ; 
    }
    public int rowWithMax1s(int arr[][]) {
       int max = 0 ;
       int size = arr[0].length;
       int index = -1 ;
       for(int i = 0 ; i < arr.length; i++) {
           int index_1 = solverawcount(arr[i] , 1 ) ;
           int cnt_1 = size - index_1 ;
           if(cnt_1 > max) {
               max = cnt_1;
               index = i ;
           }
       }
       return index ; 
    }
}