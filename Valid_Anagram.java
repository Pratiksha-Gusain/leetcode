class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[]=new int[26];
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++)
          arr[s.charAt(i)-'a']++;
        for(int j=0;j<t.length();j++)
          arr[t.charAt(j)-'a']--;
        for(int k=0;k<arr.length;k++)
        {
            if(arr[k]!=0)
               return false;
        }
        return true;
        
    }
}