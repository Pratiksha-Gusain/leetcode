class Solution {
    int timer =1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it: connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int low[]= new int[n];
        int time[] = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(adj,low,time,vis,0,-1,bridges);
        return bridges;
    }
    void dfs(List<List<Integer>> adj, int[]low, int[]time, boolean[]vis,int node,int parent,List<List<Integer>>bridges){
        vis[node]=true;
        time[node]=low[node]=timer++;
        for(int neighbor: adj.get(node)){
            if(neighbor==parent) continue;
            if(!vis[neighbor]){
                dfs(adj,low,time,vis,neighbor,node,bridges);
                low[node]=Math.min(low[node],low[neighbor]);
                if(low[neighbor]>time[node])
                    bridges.add(Arrays.asList(neighbor,node));

            }
            else{
                low[node]=Math.min(low[node],time[neighbor]);
            }
        }
    }
}