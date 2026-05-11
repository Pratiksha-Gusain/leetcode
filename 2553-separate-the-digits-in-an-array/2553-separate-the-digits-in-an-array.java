class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            List<Integer> l = new ArrayList<>();
            while(num > 0){
                int digit = num % 10;
                num /=  10;
                l.add(digit);
            }
            for(int i = l.size()-1; i>=0; i--){
                list.add(l.get(i));
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}