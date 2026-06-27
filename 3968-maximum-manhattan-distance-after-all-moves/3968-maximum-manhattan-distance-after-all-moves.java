class Solution {
    public int maxDistance(String moves) {
        int x = 0, y = 0, ct = 0;
        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            if( ch == 'L') x-=1;
            else if( ch == 'R') x+=1;
            else if(ch == 'U') y-=1;
            else if(ch == 'D') y+=1;
            else ct++;
        }
        int ans = (Math.abs(x) + Math.abs(y));
        return ans + ct;
    }
}