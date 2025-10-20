class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            map.put(i,1);
        }
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i)==1){
                list.add(i);
                map.put(i,0);
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}