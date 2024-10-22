class Solution {
    int answer = -1;
    int[][] dg;
    public int solution(int k, int[][] dungeons) {
        dg = dungeons;
        for(int i=0; i<dungeons.length; i++){
            if(k<dg[i][0]) continue;
            boolean[] visited = new boolean[dungeons.length];
            visited[i]=true;
            dfs(k-dg[i][1],1,visited);
        }
        return answer;
    }
    public void dfs(int rest, int n,boolean[] visited){
        for(int i=0; i<dg.length; i++){
            if(visited[i]) continue;
            if(dg[i][0]>rest) continue;
            visited[i]=true;
            dfs(rest-dg[i][1],n+1,visited);
            visited[i]=false;
        }
        answer = Math.max(answer,n);
        return;
    }
}