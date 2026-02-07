class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] indegree = new int[graph.length];
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) 
            revAdj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j: graph[i]){
                revAdj.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int i: revAdj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
        }
        Collections.sort(ans);
        return ans;

    }
}