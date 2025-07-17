class Solution {
    public String reverseVowels(String s) {
        char[] c= s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(c[i]!='a'&&c[i]!='e'&&c[i]!='i'&&c[i]!='o'&&c[i]!='u'&&c[i]!='A'&&c[i]!='E'&&c[i]!='I'&&c[i]!='O'&&c[i]!='U')
                i++;
            else if(c[j]!='a'&&c[j]!='e'&&c[j]!='i'&&c[j]!='o'&&c[j]!='u'&&c[j]!='A'&&c[j]!='E'&&c[j]!='I'&&c[j]!='O'&&c[j]!='U')    
                j--;
            else{    
                char temp= c[i];
                c[i]=c[j];
                c[j]=temp;
                i++;
                j--;
            } 
         }
        return String.valueOf(c); 
    }
}