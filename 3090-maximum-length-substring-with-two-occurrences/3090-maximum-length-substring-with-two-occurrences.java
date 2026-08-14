class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int max = 1;
        for(int right=0;right<s.length();right++)
        {
            hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)+1);
            while(hm.get(s.charAt(right))>2)
            {
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}