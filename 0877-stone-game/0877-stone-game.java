class Solution {
    public boolean stoneGame(int[] piles) {
        int evenIdx = 0;
        int oddIdx = 0;
        for(int i=0;i<piles.length;i++)
        {
            if(i%2==0)
            evenIdx+=piles[i];
            else
            oddIdx+=piles[i];
        }
        if(evenIdx>oddIdx || oddIdx>evenIdx)
        return true;
        return false;
    }
}