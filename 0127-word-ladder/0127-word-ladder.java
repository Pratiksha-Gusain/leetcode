class Solution {
    static class Pair{
        String word;
        int dist;
        Pair(String w, int d){
            word=w;
            dist=d;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int dist=curr.dist;
            if(word.equals(endWord)) return dist;
            char[] arr = word.toCharArray();
            for(int i=0;i<arr.length;i++){
                char org=arr[i];
                for(char c ='a';c<='z';c++){
                    if(c==org) continue;
                    arr[i]=c;
                    String newWord = new String(arr);
                    if(set.contains(newWord))
                    {   q.offer(new Pair(newWord,dist+1));
                        set.remove(newWord);
                    }
                }
                arr[i]=org;
            }
        }
        return 0;
    }
}