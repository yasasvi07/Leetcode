class Solution {
    public int gcdOfOddEvenSums(int n) {
        // using AP where a, a+d, a+2d, ...
        // sum = na + n(n+1)*d/2
        // for even a = 2
        // for odd a = 1
        int even = n*(n+2);
        int odd = n*(n+3);
        int max = Math.max(even,odd);
        int min = Math.min(even,odd);
        while(min!=0)
        {
            int r = max%min;
            max = min;
            min = r;
        }
        return max;
    }
}