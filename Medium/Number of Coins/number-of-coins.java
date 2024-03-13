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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	  
	    int[][] t = new int[M+1][V+1];
	    for(int i = 0 ; i < V+1; i++) {
	        t[0][i] = Integer.MAX_VALUE-1 ;
	    }
	    for(int i = 1 ; i < M+1 ; i++) {
	        t[i][0] = 0 ;
	    }
	    for(int j = 1 ; j < V+1 ; j++) {
	        if(j%coins[0] == 0) {
	            t[1][j] = j/coins[0] ;
	        }
	        else {
	            t[1][j] = Integer.MAX_VALUE - 1 ;
	        }
	    }
	    for(int i = 2 ; i < M+1 ; i++) {
	        for(int j = 1 ; j < V+1 ; j++) {
	            if(coins[i-1] <= j) {
	                t[i][j] = Math.min(t[i][j-coins[i-1]] + 1 , t[i-1][j]) ;
	            }
	            else {
	                t[i][j] = t[i-1][j] ;
	            }
	        }
	    }
	  
	     return (t[M][V] >= Integer.MAX_VALUE   - 1)? -1 : t[M][V] ;
	} 
}