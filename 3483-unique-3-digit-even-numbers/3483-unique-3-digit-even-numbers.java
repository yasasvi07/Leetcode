class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(i!=j && i!=k && j!=k)
                    {
                        if(digits[i]!=0)
                        {
                            int num1 = digits[i]*100+digits[j]*10+digits[k];
                            if(num1%2==0)
                            {
                                hs.add(num1);
                            }
                        }
                    }
                }
            }
        }
        return hs.size();
    }
}