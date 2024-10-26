class Solution {
    int answer = 0;
    
    public int solution(String word) {
        dfs(word,"",0);
        return answer;
    }
    public void dfs(String w, String dic, int depth){
        if(w.equals(dic)){
            answer=depth;
            return;
        }
        dfs(w,next(dic),depth+1);
    }
    
    public String next(String s){
        if(s.length()!=5) return s+"A";
        StringBuilder sb = new StringBuilder(s);
        boolean check = true;
        int i=4;
        while(check){
            if(sb.charAt(i)=='A') {sb.replace(i,i+1,"E"); break;}
            if(sb.charAt(i)=='E') {sb.replace(i,i+1,"I"); break;}
            if(sb.charAt(i)=='I') {sb.replace(i,i+1,"O"); break;}
            if(sb.charAt(i)=='O') {sb.replace(i,i+1,"U"); break;}
            if(sb.charAt(i)=='U') {
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        return sb.toString();
    }
}