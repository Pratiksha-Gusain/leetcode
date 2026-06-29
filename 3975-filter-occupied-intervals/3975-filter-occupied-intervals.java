class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        if(occupiedIntervals.length == 0)
            return new ArrayList<>();
        Arrays.sort(occupiedIntervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> merged = new ArrayList<>();
        int start = occupiedIntervals[0][0];
        int end = occupiedIntervals[0][1];
        for(int i = 1; i < occupiedIntervals.length; i ++){
            int s = occupiedIntervals[i][0];
            int e = occupiedIntervals[i][1];

            if(s<= end+1){
                end = Math.max(e, end);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                merged.add(temp);
                start = s;
                end = e;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        merged.add(temp);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> t : merged){
            int s = t.get(0);
            int e = t.get(1);
            if(freeStart > e || freeEnd < s){
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(s);
                temp1.add(e);              
                ans.add(temp1);
                continue;
            }
            if(freeStart > s){
                List<Integer> temp2 = new ArrayList<>();
                temp2.add(s);
                temp2.add(freeStart-1);
                ans.add(temp2);
            }
            if(freeEnd < e){
                List<Integer> temp3 = new ArrayList<>();
                temp3.add(freeEnd+1);
                temp3.add(e);
                ans.add(temp3);
            }
            
        }
        return ans;
        

    }
}