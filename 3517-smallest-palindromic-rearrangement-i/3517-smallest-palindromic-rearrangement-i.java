class Solution {
    public String smallestPalindrome(String s) {
        TreeMap<Character,Integer> hm = new TreeMap<>();
        for(int i=0;i<s.length();i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        char mid = ' ';
        boolean midFound = false; 
        for(char ch:hm.keySet())
        {
            for(int i=0;i<hm.get(ch)/2;i++)
            {
                sb.append(ch);
            }
            if(hm.get(ch)%2==1)
            {
                mid = ch;
                midFound = true;
            }
        }
        String reverse = new StringBuilder(sb).reverse().toString();
        if(midFound)
        {
            sb.append(mid);
        }
        sb.append(reverse);
        return sb.toString();
    }
}