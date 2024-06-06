//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine().trim());

            int[] A = IntArray.input(br, N);

            int Key;
            Key = Integer.parseInt(br.readLine().trim());

            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int n, int[] nums, int target) {
        // code here
         int s = 0 ;
        int e = nums.length -1 ;
        while(s <= e) {
            int mid = s + (e-s) /2 ;
            if(nums[mid] == target) {
                return true ;
            }
            if(nums[s]== nums[mid] && nums[mid] == nums[e]) {
                s = s+1;
                e = e-1 ;
                continue ;
            }
            else if (nums[s] <= nums[mid]) {
                if(target >= nums[s] &&  target <= nums[mid]) {
                    e = mid -1 ;
                }
                else {
                    s = mid  +1 ; 
                }
            }
            else {
                if (target >= nums[mid] && target <= nums[e]) {
                    s = mid +  1 ;
                }
                else {
                    e = mid -1 ;
                }
            }
            
        }
        return  false;
    
        
    }
}
