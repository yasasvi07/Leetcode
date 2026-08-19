class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
        for(int[] i:reservedSeats)
        {
            hm.putIfAbsent(i[0]-1,new HashSet<>());
            hm.get(i[0]-1).add(i[1]-1);
        }
        int cnt = (n-hm.size())*2;
        for(Map.Entry<Integer,HashSet<Integer>> entry:hm.entrySet())
        {
            boolean left = true;
            boolean middle = true;
            boolean right = true;
            Set<Integer> hs = entry.getValue();
            for(int j=1;j<5;j++)
            {
                if(hs.contains(j))
                {
                    left = false;
                    break;
                }
            }
            for(int j=3;j<7;j++)
            {
                if(hs.contains(j))
                {
                    middle = false;
                    break;
                }
            }
            for(int j=5;j<9;j++)
            {
                if(hs.contains(j))
                {
                    right = false;
                    break;
                }
            }
            if(left && right)
            cnt+=2;
            else if(left || middle || right)
            cnt++;
        }
        return cnt;
    }
}