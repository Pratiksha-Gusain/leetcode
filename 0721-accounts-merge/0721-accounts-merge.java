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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    ds.union(i,map.get(mail));
                }
                else{
                    map.put(mail,i);
                }
            }
        }
        ArrayList<String>[] merged = new ArrayList[n];
        for(int i=0;i<n;i++) merged[i]= new ArrayList<>();
        for(Map.Entry<String,Integer> it : map.entrySet()){
            int node = ds.find(it.getValue());
            String s = it.getKey();
            merged[node].add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged[i].isEmpty()) continue;
            Collections.sort(merged[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : merged[i]){
                temp.add(it);
            }
            res.add(temp);
        }
        return res;  
    }

}