class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totSum = 0;
        for(int i:nums)
        {
            totSum+=i;
        }
        int remaining = totSum-x;
        if(remaining<0)
        return -1;
        if(remaining==0)
        return n;
        int left = 0;
        int maxLen = -1;
        int sum = 0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];
            while(sum>remaining)
            {
                sum-=nums[left];
                left++;
            }
            if(sum==remaining)
            {
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen==-1?-1:n-maxLen;
    }
}