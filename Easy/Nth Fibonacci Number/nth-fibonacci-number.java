//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    
    static int nthFibonacci(int n){
        // code here
        int[] fib = new int[n+1] ;
        for(int i = 1 ; i < n +1; i++) {
            fib[i] = -1; 
        }
        return solve( n , fib) ;
        }
        static int solve (int  n , int[] fib) {
            if(n == 0) {
                return 0 ;
            }
            if(n== 1) {
                return 1 ;
            }
            if(fib[n] != -1 ) {
                return fib[n] ;
            }
            return fib[n] = (solve(n-1 , fib) + solve(n-2 , fib)) %1000000007;
        }
}