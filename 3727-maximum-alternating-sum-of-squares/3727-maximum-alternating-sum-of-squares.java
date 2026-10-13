class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] a = new long[n];
        for(int i=0;i<n;i++)
        {
            a[i] = (nums[i]*nums[i]);
        }
        Arrays.sort(a);
        long left = 0;
        for(int i=0;i<n/2;i++)
        {
            left+=a[i];
        }
        long right = 0;
        for(int i=n/2;i<n;i++)
        {
            right+=a[i];
        }
        return right-left;
    }
}