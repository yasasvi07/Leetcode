class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        //int[] connected = new int[n];
        boolean[] edge = new boolean[n-1];
        for(int i=0;i<n-1;i++)
        {
            edge[i] = Math.abs(nums[i]-nums[i+1])<=maxDiff;
        }
        for(int i=0;i<queries.length;i++)
        {
            int u = queries[i][0];
            int v = queries[i][1];
            if(u==v)
            {
                ans[i] = true;
                continue;
            }
            ans[i] = true;
            int l = Math.min(u,v);
            int r = Math.max(u,v);
            for(int j=l;j<r;j++)
            {
                if(!edge[j])
                {
                    ans[i] = false;
                    break;
                }
            }
        }
        return ans;
    }
}