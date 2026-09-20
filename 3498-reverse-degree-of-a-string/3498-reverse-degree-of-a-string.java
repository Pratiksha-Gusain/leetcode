class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int curr = 'z' - s.charAt(i)+1;
            sum += curr * (i+1);
        }
        return sum;
    }
}