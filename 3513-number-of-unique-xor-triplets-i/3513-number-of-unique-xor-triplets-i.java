class Solution {
    public int power(int a,int n)
    {
        if(n==0)
        return 1;
        int pow = power(a,n/2);
        if(n%2==0)
        return pow*pow;
        return pow*pow*a;
    }
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2)
        {
            return n;
        }
        int max = nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]>max)
            {
                max = nums[i];
            }
        }
        String s = Integer.toBinaryString(max);
        int pow = power(2,s.length());
        return pow;
    }
}