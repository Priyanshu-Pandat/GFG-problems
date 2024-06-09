//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
     public static int solve(int[] v, int hourly, int n) {
  int totalH = 0;
    
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
    public static int Solve(int N, int[] piles, int h) {
        
        // code here
          int max = Integer.MIN_VALUE;
    int n = piles.length;
    for (int i = 0; i < n; i++) {
        if (piles[i] > max) {
            max = piles[i];
        }
    }
    int low = 1; // Minimum possible eating speed
    int high = max; // Maximum pile size
    int ans = max; // Initialize with the maximum value possible
    while (low <= high) {
             while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = solve(piles, mid , n );
            if (totalH <= h) {
                ans = mid ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
        return ans;
    }
    
}
        
