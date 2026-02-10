class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);

        }
        PriorityQueue <Map.Entry<Character, Integer>> pq =new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(hm.entrySet());
        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }       
        return sb.toString();
    }
}