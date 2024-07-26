//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] nums , int N, int k) {
        // code here
         int sum = 0 ; 
        int maxi = 0 ;
        int n = nums.length;
        for(int i = 0 ; i < n ;i++ ) {
            sum+= nums[i] ;
            maxi = Math.max(maxi , nums[i]) ;
        }
        int s = maxi;
        int e = sum ;
        int ans = 0 ;
        while(s <= e) {
            int mid = (s+e)/2 ;
            if(solve(mid , n , nums , k )) {
              ans = mid ;
              e = mid - 1 ;
            }
            else {
                s = mid + 1 ;
            }
        } 
        return ans ;       
    }
    public static boolean solve(int mid , int n , int[] nums , int k) {
        int count = 1 ; 
        int sum = 0 ;
        for(int i = 0 ; i < n ; i++) {
           if(sum + nums[i] <= mid) {
            sum+= nums[i] ;
           }
           else {
            count++ ;
            if(count > k ||  nums[i] > mid  ) {
                return false ;
            }
            sum = nums[i]; 
           }
        }
        return true ;
    
    }
};