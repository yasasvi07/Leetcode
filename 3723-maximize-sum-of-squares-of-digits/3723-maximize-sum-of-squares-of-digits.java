class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum)
        return "";
        StringBuilder sb = new StringBuilder();
        int cnt = sum/9;
        int rem = sum%9;
        while(cnt>0)
        {
            sb.append(9);
            cnt--;
        }        
        if(sb.length()<num)
        {
            sb.append(rem);
            int dif = num-sb.length();
            while(dif>0)
            {
                sb.append(0);
                dif--;
            }
        }
        return sb.toString();
    }
}