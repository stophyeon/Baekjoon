import java.util.*;
class Solution {
    int ul;
    int bl;
    String[] user;
    String[] ban;
    Set<Set<String>> ans = new HashSet<>();
    int answer = 0;
    public int solution(String[] user_id, String[] banned_id) {
        
        ul=user_id.length;
        bl=banned_id.length;
        user=user_id;
        ban=banned_id;
        
            
        boolean[] visited = new boolean[ul];
        Set<String> set  = new HashSet<>();
        dfs(0,visited,set);
        
        return ans.size();
    }
    public void dfs(int cnt, boolean[] visited, Set<String> set){
        if(cnt==bl) {
            ans.add(set);
            return;
        }
        
        String[] b = ban[cnt].split("");
        for(int j=0; j<ul; j++){
            if(visited[j]) continue;
            String[] u = user[j].split("");
            if(check(u,b)){
                visited[j]=true;
                set.add(user[j]);
                dfs(cnt+1,visited,new HashSet<>(set));
                set.remove(user[j]);
                visited[j]=false;
            }
        }
    }
    
    public boolean check(String[] u, String[] b){
        if(u.length!=b.length) return false;
        for(int i=0; i<u.length; i++){
            if(b[i].equals("*")) continue;
            if(!u[i].equals(b[i])) return false;
        }
        return true;
    }
}