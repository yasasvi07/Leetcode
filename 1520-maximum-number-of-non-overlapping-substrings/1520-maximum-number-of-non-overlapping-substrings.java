class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] st = new int[26];
        int[] en = new int[26];
        Arrays.fill(st,n);
        Arrays.fill(en,-1);
        for(int i=0;i<n;i++)
        {
            if(st[s.charAt(i)-'a']==n)
            {
                st[s.charAt(i)-'a'] = i;
            }
            en[s.charAt(i)-'a'] = i;
        }
        List<int[]> interval = new ArrayList<>();
        for(int ch=0;ch<26;ch++)
        {
            if(en[ch]==-1)
            continue;
            int start = st[ch];
            int end = en[ch];
            boolean flag = true;
            for(int i=start;i<=end;i++)
            {
                int cur = s.charAt(i)-'a';
                if(st[cur]<start)
                {
                    flag = false;
                    break;
                }
                end = Math.max(end,en[cur]);
            }
            if(flag)
            interval.add(new int[]{start,end});
        }
        interval.sort((a,b)->{
            if(a[1]!=b[1])
            return Integer.compare(a[1],b[1]);
            return Integer.compare(a[1]-a[0],b[1]-b[0]);
        });
        List<String> ans = new ArrayList<>();
        int prev = -1;
        for(int[] i:interval)
        {
            int start = i[0];
            int end = i[1];
            if(start>prev)
            {
                ans.add(s.substring(start,end+1));
                prev = end;
            }
        }
        return ans;
    }
}