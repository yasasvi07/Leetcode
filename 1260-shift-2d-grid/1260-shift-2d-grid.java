class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> oneD = new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                oneD.add(grid[i][j]);
            }
        }
        int size = oneD.size();
        k = k%size;
        List<Integer> result = new ArrayList<>();
        for(int i=size-k;i<size;i++)
        {
            result.add(oneD.get(i));
        }
        for(int i=0;i<size-k;i++)
        {
            result.add(oneD.get(i));
        }
        List<List<Integer>> ans = new ArrayList<>();
        int q = 0;
        for(int i=0;i<grid.length;i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<grid[0].length;j++)
            {
                row.add(result.get(q));
                q++;
            }
            ans.add(row);
        }
        return ans;
    }
}