class Solution {
    boolean[] visited;
    int answer = 0;
    int[][] map;
    int size;
    public int solution(int n, int[][] computers) {
        visited=new boolean[n];
        map=new int[n][n];
        size=n;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) map[i][j]=0;
                else{map[i][j]=computers[i][j];}
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
            
        }
        
        
        return answer;
    }
    void dfs(int k){
        
            int count=0;
            for(int i=0; i<size; i++){
                if(map[k][i]==1 && !visited[i]){
                    visited[k]=true;
                    dfs(i);
                }
                else{count++;}
            }
            if(count==size) visited[k]=true;
        
    }
}