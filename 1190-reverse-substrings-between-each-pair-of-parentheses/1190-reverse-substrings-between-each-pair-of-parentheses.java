class Solution {
    public void reverse(StringBuilder sb,int start,int end)
    {
        while(start<end)
        {
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(sb.length());
            }
            else if(s.charAt(i)==')')
            {
                int start = st.pop();
                int end = sb.length()-1;
                reverse(sb,start,end);
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}