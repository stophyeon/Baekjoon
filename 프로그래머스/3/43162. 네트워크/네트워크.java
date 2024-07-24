import java.util.Arrays;
class Solution {
    static int count=0;
    static int col=0;
    public int solution(int n, int[][] computers) {
        col=n;
        boolean[] visit = new boolean[n];
        Arrays.fill(visit,false);
        for(int i=0; i<n; i++){
            if(visit[i]==false){
                
                bfs(computers,visit,i);
                
            }
        }
        return n-count;
    }
    void bfs(int[][] computers ,boolean[] visit, int i){
        visit[i]=true;
        for(int j=0; j<col; j++){
            if(i!=j && computers[i][j]==1&&visit[j]==false){
                count++;
                bfs(computers,visit,j);
            }
        }
        
    }
}