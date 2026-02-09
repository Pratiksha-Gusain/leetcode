class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int row = times.length;
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int time[]:times){
            int u= time[0];
            int v=time[1];
            int w = time[2];
            adj.get(u).add(new int[]{v,w});
        }
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k]=0;
        q.offer(new int[]{0,k});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int d=curr[0];
            int u = curr[1];
            if(d>ans[u]) continue;
            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];
                if(ans[u]+w<ans[v]){
                    ans[v]= ans[u]+w;
                    q.offer(new int[]{ans[v],v});
                }
            }
        }
        int res = 0;
        for(int i=1;i<=n;i++){
            res = Math.max(res,ans[i]);
        }
        return res==Integer.MAX_VALUE?-1:res;

    }
}