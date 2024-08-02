class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int min = section[0];
        int max = section[section.length-1];
        if(max-min+1<=m) return 1;
        boolean[] visited = new boolean[n];
        for(int sec : section){
            visited[sec-1]=true;
        }
        for(int i=0; i<n; i++){
            
            if(visited[i]){
                for(int j=0; j<m; j++){
                    if(i+j>=n){break;} 
                    visited[i+j]=false;
                }
                answer++;
            }
        }
        return answer;
    }
}