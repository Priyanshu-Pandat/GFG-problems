//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      static int[][] t = new int[501][501] ;
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length() ;
       
        for(int i = 0 ; i < n+1 ; i++) {
            for(int j = 0 ; j < n+1 ; j++) {
                t[i][j] = -1 ;
            }
        }
        return solve(str , 0 , n-1) ;
    }
    static int solve(String s , int i , int j) {
        if(i >= j) {
            return 0 ;
        }
        if(ispali(s, i , j) == true) {
            return 0 ;
        }
        if(t[i][j] != -1) {
            return t[i][j] ;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i ; k <= j-1 ; k++) {
            int left;
            int right ; 
            if(t[i][k] != -1) {
                left = t[i][k] ;
            }
            else {
                left = solve(s, i , k) ;
                t[i][k] = left ;
            }
              if(t[k+1][j] != -1) {
                right = t[k+1][j] ;
            }
            else {
                right = solve(s, k+1 , j) ;
                t[k+1][j] = right ;
            }
            int temp = left+right + 1 ;
            if(temp < min) {
                min = temp ;
            }
        }
        return t[i][j] = min ;
    }
    static boolean ispali(String s, int i , int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false ;
            }
            else {
                i++;
                j-- ;
            }
        }
        return true  ;
    }
}