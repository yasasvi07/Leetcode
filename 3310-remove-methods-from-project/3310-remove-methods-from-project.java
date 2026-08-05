class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] i:invocations)
        {
            int u = i[0];
            int v = i[1];
            graph.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        boolean[] suspicious = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        vis[k] = true;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(int neigh:graph.get(cur))
            {
                if(!vis[neigh])
                {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        for(int[] i:invocations)
        {
            int u = i[0];
            int v = i[1];
            if(!vis[u] && vis[v])
            {
                for(int j=0;j<n;j++)
                {
                    ans.add(j);
                }
                return ans;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            ans.add(i);
        }
        return ans;
    }
}