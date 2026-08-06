class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++)
        {
            int mul = 1;
            int x = i;
            while(x>0)
            {
                int r = x%10;
                mul*=r;
                x/=10;
            }
            if(mul%t==0)
            {
                return i;
            }
        }
        return -1;
    }
}