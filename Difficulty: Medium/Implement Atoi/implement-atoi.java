//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class aToi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.atoi(str);

            System.out.println(num);
            t--;
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

/*You are required to complete this method */
class Solution {
    public int atoi(String s) {
         s= s.trim();
  if(s.length() == 0) {
    return 0 ;
  }
  boolean neg = false ;
  long ans = 0 ;
  for(int i = 0 ;i < s.length(); i++) {
    char ch = s.charAt(i);
    if(i == 0) {
        if(ch ==  '-') {
         neg = true ;
         continue;
        }
        else if(ch == '+') {
            neg = false ;
            continue ;
        }
    }
    if(ch >= '0' && ch <= '9') {
    int digit = ch - '0';
    ans = ans*10 + digit ;
    if(neg) {
    long check = -ans;
    if(check < Integer.MIN_VALUE) {
      return   Integer.MIN_VALUE ;
    }
    }
    else {
        if(ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE ;
        }
    }
    }
    else {
        return -1 ;
    }
  }
  if(neg) {
    ans = -ans;
  }
  return (int)ans;
    }
}
