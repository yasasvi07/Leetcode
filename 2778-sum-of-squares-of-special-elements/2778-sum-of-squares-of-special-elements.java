class Solution {
    public int sumOfSquares(int[] nums) {
        int res=0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(n%(i+1)==0)
            {
                int mul=nums[i]*nums[i];
                res+=mul;
            }
        }
        return res;
    }
}