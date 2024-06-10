//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean solve (int mid , int[] arr , int n , int d) {
        int lw = 0 ;
        int cnt = 1 ;
        for(int i = 0 ; i < n ; i++) {
            if(lw + arr[i] <= mid) {
                lw+= arr[i] ;
            }
            else {
                cnt++;
                if(cnt > d || arr[i] > mid)  return false ;
                lw = arr[i] ;
            }
        }
        return true ;
    }
    static int leastWeightCapacity(int[] arr, int n, int d) {
        
        // code here
        int sum = 0;
        int min = -1 ;
        if(d > n)  return -1 ;
        
    
        for(int i = 0 ; i < n ; i++) {
            sum+=arr[i];
            min = Math.min(min , arr[i]) ;
        }
        
        int ans = sum ;
        int low = min ;
        int high = sum ;
        while(low <= high) {
            int mid = (low + high ) / 2 ;
            if(solve(mid , arr , n  ,d )) {
                ans = mid ;
                high = mid - 1 ;
            }
            else {
                low = mid + 1 ;
                }
        }
        return ans ;
        }
};