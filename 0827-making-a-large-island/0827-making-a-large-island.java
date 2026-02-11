class Solution {
    class DisjointSet{
        int[] parent,size;
        DisjointSet(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int find(int node){
            if(parent[node]==node) return node;
            return parent[node]=find(parent[node]);
        }
        void union(int u, int v){
            int pu=find(u), pv = find(v);
            if(pu==pv) return;
            if(size[pu]<size[pv]){
                parent[pu]=pv;
                size[pv]+=size[pu];
            }
            else{
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }
        public int getSize(int root) { 
            return size[root]; 
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int[] d : dir){
                    int newRow = i+ d[0];
                    int newCol = j+d[1];
                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1)
                        ds.union(i*n+j, newRow*n+newCol);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> components = new HashSet<>();
                for(int[] d : dir){
                    int newRow = i+ d[0];
                    int newCol = j+d[1];
                    if(newRow>=0&&newRow<n&&newCol>=0&&newCol<n&&grid[newRow][newCol]==1)
                        components.add(ds.find(newRow*n+newCol));
                }
                int currsize = 1;
                for(int it: components){
                    currsize += ds.getSize(it);
                }
                ans = Math.max(ans,currsize);
            }
        }
        if (ans==0){
            ans =n*n;
        }
        return ans;
    }
}