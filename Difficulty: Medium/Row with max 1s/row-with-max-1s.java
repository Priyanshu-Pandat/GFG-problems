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
    public int rowWithMax1s(int arr[][]) {
        int cnt = 0 ;
        
        int maxi = -1;
        for(int i = 0 ; i < arr.length; i++) {
            int cnt_1 = 0 ;
            for(int j = 0 ; j < arr[0].length ; j++) {
                if(arr[i][j] == 1 ) {
                    cnt_1++ ;
                }
            }
            
            if( cnt < cnt_1) {
                cnt = cnt_1 ;
                maxi = i ;
            }
   
        }
        
        // code here
  
        return maxi
        ;
    }
}