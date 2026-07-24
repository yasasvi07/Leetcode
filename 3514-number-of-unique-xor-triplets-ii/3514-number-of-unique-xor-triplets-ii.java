class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1)
        return 1;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                hs.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer> hs1 = new HashSet<>();
        for(int i:hs)
        {
            for(int j=0;j<n;j++)
            {
                hs1.add(i^nums[j]);
            }
        }
        return hs1.size();
    }
}