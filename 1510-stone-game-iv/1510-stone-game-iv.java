class Solution {
    static boolean[] win = new boolean[100001];
    static{
        List<Integer> sq = new ArrayList<>();
        for(int i=1;i<=(int)Math.sqrt(100000);i++)
        {
            sq.add(i*i);
        }
        for(int i=1;i<100001;i++)
        {
            for(int j:sq)
            {
                if(j>i)
                break;
                if(!win[i-j])
                {
                    win[i] = true;
                    break;
                }
            }
        }
    }
    public boolean winnerSquareGame(int n) {
        return win[n];
    }
}