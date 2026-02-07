class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        int[] topo = new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            topo[index++]=curr;
            for(int neighbor:graph.get(curr)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0) q.offer(neighbor);
            }
        }
        return index==numCourses?  topo: new int[0];
    }
}