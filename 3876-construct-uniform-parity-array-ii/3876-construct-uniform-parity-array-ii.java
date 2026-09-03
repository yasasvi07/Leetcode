class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int min = nums1[0];
        int even = 0;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]<min)
            min = nums1[i];
            if(nums1[i]%2==0)
            even++;
        }
        if(min%2!=0)
        return true;
        if(even==n)
        return true;
        return false;
    }
}