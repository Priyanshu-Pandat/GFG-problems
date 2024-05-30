//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
          Arrays.sort(nums) ;
         int n = nums.length ;
        for(int i = 0 ; i < n ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue ;
            }
            for(int j = i+1 ; j < n ; j++ ) {
                 if(j > i+1 && nums[j] == nums[j-1]) {
                continue ;
            } 
            int l = j+1 ;
            int r = n - 1 ;
            while ( l < r) {
             long sum = nums[i];
              sum += nums[j];
              sum += nums[l];
              sum += nums[r];
              if(sum == target) {
                 ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        ans.add(temp);
                        l++ ;
                        r-- ;
                        while( l < r && nums[l] == nums[l-1]) l++ ;
                        while ( l < r && nums[r] == nums[r+1]) r-- ;
              }
              else if (sum < target) {
                l++ ;
              }
              else {
                r-- ;
              }
            }
            }
        }
        return ans ;
    }
}