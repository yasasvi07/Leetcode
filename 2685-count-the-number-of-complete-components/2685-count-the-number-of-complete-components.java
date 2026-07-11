class Solution {
    public List<Integer> bfs(List<List<Integer>> adj,int src,boolean[] vis)
    {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> components = new ArrayList<>();
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            components.add(cur);
            for(int neigh:adj.get(cur))
            {
                if(!vis[neigh])
                {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        return components;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] i:edges)
        {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                List<Integer> components = bfs(adj,i,vis);
                int edge = 0;
                for(int j:components)
                {
                    edge+=adj.get(j).size();
                }
                edge/=2;
                int k = components.size();
                int kvertices = k*(k-1)/2;
                if(kvertices==edge)
                cnt++;
            }
        }
        return cnt;
    }
}