class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        solve(1,k,n,ans, new ArrayList<>());
        return ans;
    }
    public void solve(int i,int k,int n, List<List<Integer>> ans,List<Integer>curr){
        if(k==0 && n == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int ind = i; ind <= 9; ind++){
            if(ind > n || k <=0) break;
            curr.add(ind);
            solve(ind+1,k-1,n-ind,ans, curr);
            curr.remove(curr.size()-1);
        }
        
    }
}