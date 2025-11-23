class Solution {
    public String minWindow(String s, String t) {
        int cnt=0;
        int minlen=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int sIndex=-1;
        int eIndex=-1;
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),0);
        }
        while(r<s.length()){
            if(map.get(s.charAt(r))>0) cnt++;
            map.put(s.charAt(r), map.get(s.charAt(r))-1);
            while(cnt==t.length()){
                if((r-l+1)<minlen){
                    minlen=r-l+1;
                    sIndex=l;
                    eIndex=r;
                }
                map.put(s.charAt(l), map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) cnt--;
                l++;
            }
            r++;
        }
        return sIndex==-1?"":s.substring(sIndex,eIndex+1);
    }
}