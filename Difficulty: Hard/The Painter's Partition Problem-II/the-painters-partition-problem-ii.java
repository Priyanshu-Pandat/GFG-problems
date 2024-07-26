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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
      public static boolean solve(long mid , int n , int[] nums , int k) {
        long count = 1 ; 
        long sum = 0 ;
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
    static long minTime(int[] nums ,int n,int k){
        //code here
          long sum = 0 ; 
        long maxi = 0 ;
       
        for(int i = 0 ; i < n ;i++ ) {
            sum+= nums[i] ;
            maxi = Math.max(maxi , nums[i]) ;
        }
        long s = maxi;
        long  e = sum ;
        long ans = 0 ;
        while(s <= e) {
            long mid = (s+e)/2 ;
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
}


