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
    }
    public int removeStones(int[][] stones) {
        int maxRow=0, maxCol=0;
        for(int[] s: stones){
            maxRow = Math.max(maxRow,s[0]);
            maxCol = Math.max(maxCol,s[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        Set<Integer> nodes = new HashSet<>();
        for(int[] s : stones){
            int row = s[0];
            int col= s[1]+maxRow+1;
            ds.union(row,col);
            nodes.add(row);
            nodes.add(col);
        }
        int components = 0;
        for(int node:nodes){
            if(ds.find(node)==node) components++;
        }
        return stones.length - components;
    }
}