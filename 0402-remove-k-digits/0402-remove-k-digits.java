class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack <>();
        for(int i = 0; i < n; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        while(res.length() > 0 && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }
        if (res.length() == 0) return "0";

        res.reverse();
        return res.toString();
    }
}