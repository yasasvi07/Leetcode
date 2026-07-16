class Solution {
    public int gcd(int a,int b)
    {
        if(a==0)
        return b;
        if(b==0)
        return a;
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while(min!=0)
        {
            int r = max%min;
            max = min;
            min = r;
        }
        return max;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] mx = new int[n];
        mx[0] = nums[0];
        for(int i=1;i<n;i++)
        {
            mx[i] = Math.max(mx[i-1],nums[i]);
        }
        int[] prefix = new int[n];
        for(int i=0;i<n;i++)
        {
            prefix[i] = gcd(nums[i],mx[i]);
        }
        Arrays.sort(prefix);
        long sum = 0;
        int p1 = 0;
        int p2 = n-1;
        int mid = n/2;
        while(p1<mid && p2>=mid)
        {
            sum += gcd(prefix[p1],prefix[p2]);
            p1++;
            p2--;
        }
        return sum;
    }
}