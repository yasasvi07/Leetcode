class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0;i<knowledge.size();i++)
        {
            hm.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);
            if(x=='(')
            {
                int left = i;
                int right = i+1;
                while(s.charAt(right)!=')')
                {
                    right++;
                }
                String k = s.substring(left+1,right);
                if(hm.containsKey(k))
                {
                    sb.append(hm.get(k));
                }
                else
                {
                    sb.append('?');
                }
                i = right;
            }
            else{
            sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}