class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u=road[0], v=road[1], dis = road[2];
            graph.get(u).add(new int[]{v, dis});
            graph.get(v).add(new int[]{u, dis});
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        q.offer(new long[]{0,0});
        int MOD = 1_000_000_007;
        while(!q.isEmpty()){
            long[] curr = q.poll();
            long d =curr[0];
            int node = (int) curr[1];
            if (d > dist[node]) continue;

            for(int[] i : graph.get(node)){
                int nextNode = i[0];
                int dis = i[1];
                if(dist[node]+dis<dist[nextNode]){
                    dist[nextNode]= dist[node]+dis;
                    q.offer(new long[]{dist[nextNode],nextNode});
                    ways[nextNode]=ways[node];
                }
                else if(dist[node]+dis==dist[nextNode])
                ways[nextNode]=(ways[node]+ways[nextNode])%MOD;

            }
        }
        return ways[n-1];

    }
}