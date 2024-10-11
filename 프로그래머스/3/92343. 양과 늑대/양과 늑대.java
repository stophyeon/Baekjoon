import java.util.*;
class Solution {
    int answer = 0;
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    int[] type;
    
    public int solution(int[] info, int[][] edges) {
        type=info;
        for(int[] edge : edges){
            if(map.containsKey(edge[0])){
                map.get(edge[0]).add(edge[1]);
            }
            else{
                List<Integer> l = new ArrayList<>();
                l.add(edge[1]);
                map.put(edge[0],l);
            }
        }
        
        boolean[] visited = new boolean[info.length];
        visited[0]=true;
        
        List<Integer> path = new ArrayList<>();
        for(int i=0; i<map.get(0).size(); i++){
            path.add(map.get(0).get(i));
        }
        
        dfs(0,path,visited,1,0);
        return answer;
    }
    public void dfs(int n, List<Integer> path ,boolean[] visited,int s, int w){
        if(w>=s) return;
        answer = Math.max(answer, s);
        for(int num : path){
            if(visited[num]) continue;
            visited[num]=true;
            List<Integer> p = new ArrayList<>(path);
            if(map.containsKey(num)){
                for(int i=0; i<map.get(num).size(); i++){
                    p.add(map.get(num).get(i));
                }
            } 
            
            if(type[num]==0) dfs(num, p,visited,s+1,w);
            if(type[num]==1) dfs(num, p,visited,s,w+1);
            visited[num]=false;
        }
    }
    
}