class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1) return s;
        int maxOddIndex = (n%2 == 0)? n-1 : n-2;
        int steps = (maxOddIndex+1)/2;
        return (long) s + (long) steps * m - (steps-1);
    }
}