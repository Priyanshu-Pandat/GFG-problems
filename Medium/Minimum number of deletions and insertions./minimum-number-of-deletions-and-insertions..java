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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2)
	
	{ 
	    
	    return lcs(str1 , str2 , str1.length() , str2.length() );
	    
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
        int insertion  = n - t[m][n];
        int deletion   = m - t[m][n] ;
        return (insertion + deletion);
     }
}