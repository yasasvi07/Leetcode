class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String s = "123456789";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            sb.append(s.charAt(i));
            for(int j=i+1;j<s.length();j++)
            {
                sb.append(s.charAt(j));
                if(Integer.parseInt(sb.toString())<=high && Integer.parseInt(sb.toString())>=low)
                {
                    ans.add(Integer.parseInt(sb.toString()));
                }
            }
            sb.setLength(0);
        }
        Collections.sort(ans);
        return ans;
    }
}