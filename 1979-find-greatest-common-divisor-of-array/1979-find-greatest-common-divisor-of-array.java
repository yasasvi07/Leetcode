class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min = nums[i];
            }
            if(nums[i]>max)
            {
                max = nums[i];
            }
        }
        while(min!=0)
        {
            int r = max%min;
            max = min;
            min = r;
        }
        return max;
    }
}