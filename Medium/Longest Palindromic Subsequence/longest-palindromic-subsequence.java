//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        String s = "" ;
        for(int i = S.length()-1 ; i >= 0 ; i--) {
            s+= S.charAt(i) ;
        }
        return lcs(S , s , S.length() , S.length()) ;
    }
     public static int lcs(String X,String Y,int m,int n) {
         int[][] t = new int[m+1][n+1] ;
           for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(i==0 || j==0)
                {
                    t[i][j] = 0;
                }
            }
        }
         for(int i = 1 ; i < m+1; i++) {
             for(int j = 1 ; j < n+1 ; j++) {
                 if(X.charAt(i-1) == Y.charAt(j-1)) {
                     t[i][j] = 1 + t[i-1][j-1];
                 }
                 else {
                     t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                 }
             }
         }
         return t[m][n] ;
     }
}