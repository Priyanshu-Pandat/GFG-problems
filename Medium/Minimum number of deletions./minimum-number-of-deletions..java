//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String S, int n)
    {
    
        
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
         return  m - t[m][n]  ;
     }
} 