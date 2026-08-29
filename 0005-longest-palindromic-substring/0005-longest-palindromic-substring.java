class Solution {
    public String longestPalindrome(String s) {
        // using manacher's algorithm
        int n = s.length();
        if(n==1)
        return s;
        char[] t = new char[2*n+3];
        t[0] = '^';
        t[t.length-1] = '$';
        int[] p = new int[t.length];
        for(int i=0;i<n;i++)
        {
            t[2*i+1] = '#';
            t[2*i+2] = s.charAt(i);
        }
        t[t.length-2] = '#';
        int center = 0;
        int right = 0;
        int max = 0;
        int maxcenter = 0; 
        for(int i=1;i<t.length-1;i++)
        {
            int mirror = 2*center-i;
            if(i<right)
            p[i] = Math.min(p[mirror],right-i);
            while(t[i+1+p[i]] == t[i-1-p[i]])
            {
                p[i]++;
            }
            if(i+p[i] > right)
            {
                center = i;
                right = i+p[i];
            }
            if(p[i] > max)
            {
                max = p[i];
                maxcenter = i;
            }
        }
        int st = (maxcenter - max) / 2;
        return s.substring(st,st+max);
    }
}