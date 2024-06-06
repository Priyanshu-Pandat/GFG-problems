//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
          int s = 0 ; 
        int n = arr.length ;
        int e =  n-1;
        
      int mid  = s + (e-s) /2 ;
        while(s<=e) {
            if(arr[s] <= arr[e]) {
                return arr[s] ; 
            }
             mid  = s + (e-s) /2 ; 
             int next = (mid+1) % n ;
             int prev = (mid + n  -1) % n;
              if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                  return arr[mid] ; 
              }
              else if (arr[s] <= arr[mid]) {
                  s = mid + 1 ;
              }
              else {
                  e = mid - 1 ;
              }
        }
       return 0 ;
    }
}