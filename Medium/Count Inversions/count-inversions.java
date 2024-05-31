//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long mergeArray(long arr[] , long low , long mid , long high) {
          ArrayList<Long> temp = new ArrayList<>();
          int left = (int)low ;
          int right = (int)mid+1;
          long cnt = 0 ;
          while(left <= mid && right <= high) {
              if(arr[left] <= arr[right]) {
                  temp.add(arr[left]) ;
                  left++;
              }
              else {
                  temp.add(arr[right]);
                  cnt+= mid - left + 1 ; 
                  right++ ;
              }
          }
            // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
          // transfering all elements from temporary to arr //
        for (int i = (int) low; i <= high; i++) {
            arr[i] = temp.get(i - (int) low); // Fix: Correct index calculation
        }
        
        return cnt ;
    }
    static long mergeSort (long arr[] , long low , long high) {
        long cnt = 0 ;
        if(low >= high) {
            return cnt ;
        }
        long mid = (low+high)/2 ;
        cnt+= mergeSort(arr , low , mid) ;
        cnt+= mergeSort(arr , mid+1 , high) ;
        cnt+= mergeArray(arr , low , mid , high) ;
        return cnt ;
    }
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr , 0 , N-1) ;
    }
}