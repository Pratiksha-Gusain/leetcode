class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ans = n;
        for(int i = 0; i <=n; i++){
            ans = Math.min(ans, changes(s,i,'0','1'));
            ans = Math.min(ans, changes(s,i,'1','0'));
        }
        return ans;
    }
        
        private int changes(String s, int split, char left, char right) {
        int flips = 0;
        for (int i = 0; i < split; i++) {
            if (s.charAt(i) != left) {
                flips++;
            }
        }
        for (int i = split; i < s.length(); i++) {
            if (s.charAt(i) != right) {
                flips++;
            }
        }
        return flips;
        }
}