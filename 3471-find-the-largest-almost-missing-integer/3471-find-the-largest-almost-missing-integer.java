class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,0);
        }
        for(int i=0;i<=nums.length-k;i++)
        {
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i;j<i+k;j++)
            {
                hs.add(nums[j]);
            }
            for(int j:hs)
            {
                hm.put(j,hm.get(j)+1);
            }
        }
        int max = -1;
        for(int i:hm.keySet())
        {
            if(hm.get(i)==1)
            {
                max = Math.max(max,i);
            }
        }
        return max;
    }
}