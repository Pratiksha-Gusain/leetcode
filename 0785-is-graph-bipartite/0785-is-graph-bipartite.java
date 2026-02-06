class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false) return false;
            }
        }
        return true;
    }
    boolean dfs(int i,int col,int[] color,int[][]graph){
        color[i]=col;
        for(int j: graph[i]){
            if(color[j]==-1)
            {   if(dfs(j,1-col,color,graph)==false) 
                    return false;
            }
            else if(color[j]==col) return false;
        }
        return true;

    }
}