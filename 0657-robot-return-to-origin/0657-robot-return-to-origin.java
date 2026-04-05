class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int[] pos = {0,0};
        for(int i=0; i< n; i++){
            if(moves.charAt(i)=='U') pos[0]--;
            else if(moves.charAt(i)=='D') pos[0]++;
            else if(moves.charAt(i)=='L') pos[1]--;
            else if(moves.charAt(i)=='R') pos[1]++;
        }
        if(pos[0]==0 && pos[1]==0) return true;
        return false;
    }
}