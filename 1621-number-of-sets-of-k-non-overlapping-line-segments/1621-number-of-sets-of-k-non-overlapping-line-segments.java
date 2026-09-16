class Solution {
    public int numberOfSets(int n, int k) {
        n = n+k-1;
        int r = 2*k;
        int[][] dp = new int[n+1][r+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=r&&j<=i;j++)
            {
                dp[i][j] = (dp[i-1][j]%1000000007+dp[i-1][j-1]%1000000007)%1000000007;
            }
        }
        return dp[n][r];
    }
}