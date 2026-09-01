class Solution {
    public int minMoves(String[] classroom, int energy) {
        int reset = energy;
        char[][] grid = new char[classroom.length][classroom[0].length()];
        Queue<int[]> q = new LinkedList<>();
        int totalL = 0;
        int[][] idx = new int[classroom.length][classroom[0].length()];
        for(int i=0;i<classroom.length;i++)
        {
            for(int j=0;j<classroom[0].length();j++)
            {
                grid[i][j] = classroom[i].charAt(j);
                idx[i][j] = -1;
                if(grid[i][j]=='L')
                {
                    idx[i][j] = totalL;
                    totalL++;
                }
            }
        }
        boolean[][][][] vis = new boolean[classroom.length][classroom[0].length()][1<<totalL][energy+1];
        for(int i=0;i<classroom.length;i++)
        {
            for(int j=0;j<classroom[0].length();j++)
            {
                if(grid[i][j]=='S')
                {
                    q.add(new int[]{i,j,0,0,energy});
                    vis[i][j][0][energy] = true;
                }
            }
        }
        int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
        int fullMask = (1<<totalL)-1;
        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int mask = cur[3];
            int curEnergy = cur[4];
            if(mask==fullMask)
            return dist;
            for(int[] d:dir)
            {
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]!='X')
                {
                    if(curEnergy==0)
                    continue;
                    int newEnergy = curEnergy-1;
                    int newMask = mask;
                    if(grid[nx][ny]=='R')
                    {
                        newEnergy = reset;
                    }
                    if(grid[nx][ny]=='L')
                    {
                        int id = idx[nx][ny];
                        newMask = mask|(1<<id);
                    }
                    if(!vis[nx][ny][newMask][newEnergy])
                    {
                        vis[nx][ny][newMask][newEnergy] = true;
                        q.add(new int[]{nx,ny,dist+1,newMask,newEnergy});
                    }
                }
            }
        }
        return -1;
    }
}