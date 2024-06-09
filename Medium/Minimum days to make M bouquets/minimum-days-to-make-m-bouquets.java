//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
      public static boolean solve (int[] arr , int m , int k , int n , int mid) {
        int cnt = 0 ;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= mid ){
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
    public static int solve(int m, int k, int[] arr) {
        
          int n = arr.length;
        if ((long)m*k> n ) return -1 ;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++) {
            if(arr[i] < min)  min = arr[i];
            if(arr[i] > max)  max = arr[i] ;
        }
        int low = min ;
        int high = max ;
        int ans = max ;
        while(low <= high) {
            int mid = (low+high) /2 ;
            if(solve(arr , m , k , n , mid)) {
                ans = mid ; 
                high = mid - 1 ;
            }
            else {
                low = mid  +1 ;
            }
        }
        return ans ;
    }
}