class Solution {
    public int gcd(int a,int b)
    {
        if(a==0)
        return b;
        if(b==0)
        return a;
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while(min!=0)
        {
            int r = max%min;
            max = min;
            min = r;
        }
        return max;
    }
    public int dfs(int idx,int gcd1,int gcd2,int[] nums,int[][][] dp)
    {
        if(idx==nums.length)
        {
            if(gcd1==gcd2 && gcd1!=0)
            return 1;
            return 0;
        }
        if(dp[idx][gcd1][gcd2]!=0)
        return dp[idx][gcd1][gcd2];
        long ans = 0;
        // Ignoring currect element
        ans+=dfs(idx+1,gcd1,gcd2,nums,dp);
        // Put in sequence 1
        ans+=dfs(idx+1,gcd(gcd1,nums[idx]),gcd2,nums,dp);
        //Put in sequence 2
        ans+=dfs(idx+1,gcd1,gcd(gcd2,nums[idx]),nums,dp);
        ans%=1000000007;
        return dp[idx][gcd1][gcd2] = (int)ans;
    }
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i:nums)
        {
            max = Math.max(max,i);
        }
        int[][][] dp = new int[nums.length][max+1][max+1];
        return dfs(0,0,0,nums,dp);
    }
}