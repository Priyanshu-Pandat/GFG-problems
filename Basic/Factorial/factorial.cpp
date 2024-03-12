//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends
class Solution{
public:
long long int dp[20] ; 
    long long int factorial(int N){
        //code here
         memset(dp, -1, sizeof(dp)); 
         return solve(N ) ;
        
    }
    
    long long int solve(int N) {
        if(N == 1 || N == 0){
            return 1 ;
        }
       if(dp[N] != -1) {
           return dp[N] ;
           
       }
       return dp[N] = N*solve(N-1) ;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.factorial(N) << endl;
    }
    return 0; 
}
// } Driver Code Ends