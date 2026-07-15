import java.util.*;

class Solution {
    boolean[] visited;
    int[][] edge;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        edge = computers;
        int answer = 0;
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i);
            answer++;
        }
        return answer;
    }
    
    public void dfs(int start){
        
        for(int i =0; i<edge[start].length; i++){
            if(i==start) continue;
            if(edge[start][i]==1 && !visited[i]){
                visited[i] =true;
                dfs(i);
            }
        }
        
    }
    
}