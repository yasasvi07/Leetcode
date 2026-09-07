class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[26];
        int tot = 0;
        for(int i=0;i<s.length();i++)
        {
            int ch = s.charAt(i)-'a';
            int add = (tot-dp[ch]+1000000007)%1000000007;
            dp[ch] = 1+tot;
            tot=(dp[ch]+add)%1000000007;
        }
        return tot;
    }
}