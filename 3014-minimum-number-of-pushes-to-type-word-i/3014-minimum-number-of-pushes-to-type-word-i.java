class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int blocks = n / 8;
        //8×1 + 8×2 + ... + 8×blocks
        // 8 × (1 + 2 + ... + blocks)
        // = 8 × blocks × (blocks + 1) / 2
        // = 4 × blocks × (blocks + 1)+ remaining × (blocks + 1)
        return (blocks * (blocks + 1) * 4)+ (n % 8) * (blocks + 1);
        
    }
}