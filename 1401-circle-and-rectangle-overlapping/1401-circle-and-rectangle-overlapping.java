class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for(int i=x1;i<=x2;i++)
        {
            for(int j=y1;j<=y2;j++)
            {
                int r = (int)Math.pow(xCenter-i,2)+(int)Math.pow(yCenter-j,2);
                if(r<=(int)Math.pow(radius,2))
                return true;
            }
        }
        return false;
    }
}