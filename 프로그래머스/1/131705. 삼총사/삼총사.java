import java.util.*;
class Solution {
    int[] numbers;
    
    int answer = 0;
    public int solution(int[] number) {
        numbers=number;
        boolean[] visited = new boolean[number.length];
        dfs(0,0,1,visited);
        
        return answer;
    }
    public void dfs(int i, int sum,int depth, boolean[] visited){
        
        if(depth==4){
            if(sum==0){
                answer++;
            }
            return;
        }
        
        for(int j=0; j<numbers.length; j++){
            if(!visited[j]){
                visited[j]=true;
                boolean[] visit = Arrays.copyOf(visited,visited.length);
                dfs(j,sum+numbers[j],depth+1,visit);
            }
        }
        
    }
}