class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) 
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->freq.get(a)-freq.get(b));
        for(int key: freq.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll();
        }
        return res;
    }
}