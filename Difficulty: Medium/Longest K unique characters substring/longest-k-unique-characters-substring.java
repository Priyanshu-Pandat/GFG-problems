//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String S, int K) {
        // code here
           int i = 0;
    int j = 0;
    int ans = -1;
    Map<Character, Integer> mp = new HashMap<>();
    
    while (j < S.length()) {
        char ch = S.charAt(j);
        mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        
        if (mp.size() < K) {
            j++;
        } else if (mp.size() == K) {
            ans = Math.max( ans , j-i+1) ;
            j++;
        } else if (mp.size() > K) {
            while (mp.size() > K) {
                mp.put(S.charAt(i), mp.get(S.charAt(i)) - 1);
                if (mp.get(S.charAt(i)) == 0) {
                    mp.remove(S.charAt(i));
                }
                i++;
            }
            j++;
        }
    }
    return ans;
    }
}