class Solution {
    
    public String solution(String p) {
        
        
        return dfs(p);
    }
    public String dfs(String p){
        String res="";
        if(p.equals("")) return "";
        String[] uv = balance(p);
        if(correct(uv[0])) {return uv[0]+ dfs(uv[1]);}
        
        else{
            res+="("+dfs(uv[1])+")";
            String[] uarr = uv[0].split("");
            for(int i=1; i<uarr.length-1; i++){
                if(uarr[i].equals("(")) res+=")";
                if(uarr[i].equals(")")) res+="(";
            }
        }
        return res ;
    }
    
    public String[] balance(String p){
      
       String[] parr = p.split("");
       int right =0;
        int left=0;
        int k=0;
        
       for(int i=0; i<parr.length; i++){
           if(parr[i].equals("(")) left++; 
           if(parr[i].equals(")")) right++;
           if(left==right){k=i; break;} 
       } 
        String u=p.substring(0,k+1);
        String v=p.substring(k+1);
        
        String[] s ={u,v};
        return s;
    }
    public boolean correct(String u){
        String[] uarr = u.split("");
        if(uarr[0].equals("(") && uarr[uarr.length-1].equals(")")) return true;
        return false;
    }
}