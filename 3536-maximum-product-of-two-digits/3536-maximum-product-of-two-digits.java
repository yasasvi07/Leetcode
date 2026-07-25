class Solution {
    public int maxProduct(int n) {
        List<Integer> digits = new ArrayList<>();
        int x = n;
        while(x>0)
        {
            int r = x%10;
            digits.add(r);
            x/=10;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<digits.size();i++)
        {
            if(digits.get(i)>max1)
            {
                max2 = max1;
                max1 = digits.get(i);
            }
            else if(digits.get(i)>max2)
            {
                max2 = digits.get(i);
            }
        }
        return max1*max2;
    }
}