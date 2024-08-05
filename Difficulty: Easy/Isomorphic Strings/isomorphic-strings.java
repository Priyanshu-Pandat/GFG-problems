//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s,String t)
    {
        // Your code here
                  if(s.length() != t.length()) {
            return false ; 
         }
      HashMap<Character, Character> map = new HashMap<>();

    
         for(int i = 0 ; i < s.length() ; i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i) ;
            if(!map.containsKey(si)) {
                if(!map.containsValue(ti)) {
                    map.put(si , ti) ;
                }
                else {
                    return false ;
                }
            }
            else {
             char ch = map.get(si);
           
                if(ch != ti) {
                    return false ;
                }
            }
         }
         return true ;
    
        
    }
}