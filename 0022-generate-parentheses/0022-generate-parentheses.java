class Solution {
    List<String> a = new ArrayList<>();
    void solve(int n,char[] ch,int idx,int obc,int cbc)
    {
        if(idx==n*2)
        {
            a.add(new String(ch));
            return;}
        if(obc<n)
        {
            ch[idx]='(';
            solve(n,ch,idx+1,obc+1,cbc);
        }
        if(cbc<obc)
        {
            ch[idx]=')';
            solve(n,ch,idx+1,obc,cbc+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        char[] ch = new char[n*2];
        solve(n,ch,0,0,0);
        return a;
    }
}