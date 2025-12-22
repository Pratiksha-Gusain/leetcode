class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        solve(1,k,n,ans, new ArrayList<>());
        return ans;
    }
    public void solve(int i,int k,int n, List<List<Integer>> ans,List<Integer>curr){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>9) return;
        if(n<0||k<0) return;
        curr.add(i);
        solve(i+1,k-1,n-i,ans,curr);
        curr.remove(curr.size()-1);
        solve(i+1,k,n,ans,curr);
    }
}