class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suffix = new int[n];
        int cur = m-1;
        int c = 0;
        for(int i=n-1;i>=0;i--)
        {
            suffix[i] = c;
            if(cur>=0 && word1.charAt(i)==word2.charAt(cur))
            {
                cur--;
                c++;
            }
        }
        int[] ans = new int[m];
        int j = 0;
        boolean change = false;
        for(int i=0;i<n && j<m;i++)
        {
            if(word1.charAt(i)==word2.charAt(j))
            {
                ans[j] = i;
                j++;
            }
            else if(!change && suffix[i]>=m-j-1)
            {
                ans[j] = i;
                j++;
                change = true;
            }
        }
        if(j==m)
        return ans;
        return new int[0];
    }
}