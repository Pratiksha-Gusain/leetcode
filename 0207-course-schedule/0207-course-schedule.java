class Solution {
    boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] vis, int[] pathVis){
        vis[i]=1;
        pathVis[i]=1;
        for(int j: adj.get(i)){
            if(vis[j]==0){
                if(dfs(j,adj,vis,pathVis)==true)
                    return true;
            }
            else if(pathVis[j]==1){
                return true;
            }
        }
        pathVis[i]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) 
            adj.add(new ArrayList<>());
        for(int[] row : prerequisites)
            adj.get(row[0]).add(row[1]);
        int[] vis = new int[numCourses];
        int pathVis[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis)==true) return false;
            }
        }
        return true;
    }
}