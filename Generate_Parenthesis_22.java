class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve("",0,0,n,res);
        return res;
    }
    public void solve(String curr, int open, int closed, int total, List<String> res){
        if(curr.length()==2*total){
            res.add(curr);
            return;
        }
        if(open<total) solve(curr+"(",open+1,closed,total,res);
        if(closed<open) solve(curr+")", open,closed+1,total,res);

    }
}