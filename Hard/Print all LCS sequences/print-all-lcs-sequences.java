//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public Set<String> all(String s, String t, int[][] dp, int i, int j, Object[][] arrayOfSets) 
    {

        if (arrayOfSets[i][j] != null) {
            return (Set<String>) arrayOfSets[i][j];
        }

        Set<String> set = new HashSet<>();
        if (i == 0 || j == 0) {
            set.add("");
            arrayOfSets[i][j] = set;
            return set;
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            Set<String> c = all(s, t, dp, i - 1, j - 1, arrayOfSets);
            for (String temp : c) {
                set.add(temp + s.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                set = all(s, t, dp, i - 1, j, arrayOfSets);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                Set<String> s1 = all(s, t, dp, i, j - 1, arrayOfSets);
                set.addAll(s1);
            }
        }

        arrayOfSets[i][j] = set; 
        return set;
    }
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        // Code here
         int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
       
       List<String> ans=new ArrayList<>();
       Set<String> tf=new HashSet<>();
      

       Object[][] arrayOfSets = new Object[n+1][m+1];
      
       Set<String> p=all(s,t,dp,n,m,arrayOfSets);
       for(String k:p)
       {
           ans.add(k);
       }
       Collections.sort(ans);
       return ans;
    }
         
    
}