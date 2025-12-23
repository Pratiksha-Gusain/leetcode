class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null||digits.length()==0) return res;
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve(digits,0,new StringBuilder(),res,map);
        return res;
    }
    public void solve(String digits,int i,StringBuilder comb,List<String> res, Map<Character,String>map){
        if(i==digits.length()){
            res.add(comb.toString());
            return;
        }
        String letters= map.get(digits.charAt(i));
        for(char letter:letters.toCharArray()){
            comb.append(letter);
            solve(digits,i+1,comb,res,map);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}