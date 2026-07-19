class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ys = new StringBuilder();
        StringBuilder xs = new StringBuilder();
        StringBuilder others = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == y){
                ys.append(ch);
            }
            else if(ch == x){
                xs.append(ch);
            }
            else{
                others.append(ch);
            }
        }
        return ys.append(others).append(xs).toString();
    }
}