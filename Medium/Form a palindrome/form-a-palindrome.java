//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        
        // code here
        String s = "";
        for(int i = S.length()-1 ; i >= 0 ; i--) {
            s+=S.charAt(i) ;
        }
        return  lps(S , s , S.length()) ;
    }
    public int lps(String S , String s , int m ) {
        int[][] t = new int[m+1][m+1] ;
        for(int i = 0 ; i < m+1 ; i++) {
            for(int j = 0 ; j < m+1; j++) {
                if(i== 0 || j == 0) {
                    t[i][j] = 0 ;
                }
                else if (S.charAt(i-1) == s.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1] ;
                }
                else {
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]) ;
                }
            }
        }
        return  m - t[m][m] ;
    }
}