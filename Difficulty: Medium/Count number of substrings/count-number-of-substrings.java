//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends

   
//User function Template for Java

class Solution
{
   public static long substrCount(String S, int K) {
        return atMostKDistinct(S, K) - atMostKDistinct(S, K - 1);
    }

    private static long atMostKDistinct(String S, int K) {
        int i = 0, j = 0;
        long count = 0;
        Map<Character, Integer> mp = new HashMap<>();

        while (j < S.length()) {
            char ch = S.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while (mp.size() > K) {
                char leftChar = S.charAt(i);
                mp.put(leftChar, mp.get(leftChar) - 1);
                if (mp.get(leftChar) == 0) {
                    mp.remove(leftChar);
                }
                i++;
            }

            count += (j - i + 1);
            j++;
        }

        return count;
}
}