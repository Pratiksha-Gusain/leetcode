class Solution {
    boolean isPalindrome(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start++)!= s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    void func(String s, int ind, List<String> list, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                list.add(s.substring(ind,i+1));
                func(s,i+1,list,res);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        func(s,0,list,res);
        return res;
    }
}