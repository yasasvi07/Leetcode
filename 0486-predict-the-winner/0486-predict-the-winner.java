class Solution {
    public int netScore(int[] nums,int i,int j)
    {
        if(i==j)
        return nums[i];
        int left = nums[i]-netScore(nums,i+1,j);
        int right = nums[j]-netScore(nums,i,j-1);
        return Math.max(left,right);
    }
    public boolean predictTheWinner(int[] nums) {
        return netScore(nums,0,nums.length-1)>=0;
    }
}