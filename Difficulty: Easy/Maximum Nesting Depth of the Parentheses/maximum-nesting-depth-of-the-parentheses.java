//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        
        // code here
            
        Stack<Character> st = new Stack<>() ;
        int n = s.length() ;
        int i = 0 ;
        int temp = 0 ;
        int maxi = 0 ;
        while(i<n) {
            if(s.charAt(i) == '(') {
                st.push('(') ;
                temp++ ;   
            }
            else if (s.charAt(i) == ')') {
                st.pop() ;
                maxi = Math.max(maxi , temp ) ;
                temp--; 
            }
            i++ ;
        }
        return maxi;
    }
}
        
