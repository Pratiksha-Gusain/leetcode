class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] directories = path.split("/");
        for(String dir: directories){
            if(dir.equals(".")||dir.isEmpty()) continue;
            else if(dir.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(dir);
            }
        }
        return "/"+String.join("/",st);
    }
}