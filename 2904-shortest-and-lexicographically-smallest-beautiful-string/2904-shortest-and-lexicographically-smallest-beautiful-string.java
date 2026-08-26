class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int min = 101;
        List<String> str = new ArrayList<>();
        int cnt = 0;
        for(int right=0;right<s.length();right++)
        {
            if(s.charAt(right)=='1')
            {
                cnt++;
            }
            while(cnt==k)
            {
                while(s.charAt(left)=='0')
                {
                    left++;
                }
                int len = right-left+1;
                if(len<min)
                {
                    min = len;
                    str.clear();
                    str.add(s.substring(left,right+1));
                }
                else if(len==min)
                {
                    str.add(s.substring(left,right+1));
                }
                left++;
                cnt--;
            }
        }
        if(str.isEmpty())
        return "";
        Collections.sort(str);
        return str.get(0);
    }
}