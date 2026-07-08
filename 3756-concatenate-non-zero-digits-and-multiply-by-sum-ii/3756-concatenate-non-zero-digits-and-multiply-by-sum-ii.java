class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        if(s.length()==1)
        {
            return new int[]{Integer.parseInt(s)*Integer.parseInt(s)};
        }
        int n = queries.length;
        int[] ans = new int[n];
        long[] sum = new long[s.length()];
        long[] concat = new long[s.length()];
        int[] nonZeroDigits = new int[s.length()];
        long[] pow = new long[s.length()];
        pow[0] = 1;
        if(s.charAt(0)!='0')
        {
            sum[0] = s.charAt(0)-'0';
            concat[0] = s.charAt(0)-'0';
            nonZeroDigits[0] = 1;
        }
        for(int i=1;i<s.length();i++)
        {
            char ch = s.charAt(i);
            pow[i] = (pow[i-1]*10)%1000000007;
            if(ch!='0')
            {
                sum[i] = (sum[i-1] + (ch-'0'))%1000000007;
                concat[i] = (concat[i-1]*10+(ch-'0'))%1000000007;
                nonZeroDigits[i] = nonZeroDigits[i-1]+1;
            }
            else
            {
                sum[i] = sum[i-1];
                concat[i] = concat[i-1];
                nonZeroDigits[i] = nonZeroDigits[i-1];
            }
        }
        for(int i=0;i<n;i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l>0)
            {
                long concatSum = sum[r] - sum[l-1];
                int k = nonZeroDigits[r] - nonZeroDigits[l-1];
                long leftconcat = (concat[l-1]*pow[k])%1000000007;
                ans[i] = (int)(((concat[r] - leftconcat + 1000000007)%1000000007 * concatSum)%1000000007);
            }
            else
            {
                ans[i] = (int)((sum[r] * concat[r])%1000000007);
            }
        }
        return ans;
    }
}