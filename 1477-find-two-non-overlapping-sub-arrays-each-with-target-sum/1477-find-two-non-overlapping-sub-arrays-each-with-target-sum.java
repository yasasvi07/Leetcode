class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int pre = 0;
        int left = 0;
        int[] minLen = new int[arr.length];
        Arrays.fill(minLen,Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for(int right=0;right<arr.length;right++)
        {
            pre+=arr[right];
            while(pre>target)
            {
                pre-=arr[left];
                left++;
            }
            if(pre==target)
            {
                int len = right-left+1;
                if(left>0 && minLen[left-1]!=Integer.MAX_VALUE)
                {
                    ans = Math.min(ans,len+minLen[left-1]);
                }
            }
            if(right==0)
            {
                if(pre==target)
                {
                    minLen[right] = right-left+1;
                }
            }
            else
            {
                minLen[right] = minLen[right-1];
                if(pre==target)
                {
                    minLen[right] = Math.min(minLen[right-1],right-left+1);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}