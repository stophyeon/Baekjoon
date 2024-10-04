import java.util.*;
class Solution {
    String[][] ticket;
    List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
        ticket= tickets;
        boolean[] visited = new boolean[tickets.length];
        dfs("ICN",visited,"ICN ",0);
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    public void dfs(String start, boolean[] visited,String ans,int depth){
        //System.out.println(start);
        if(depth==ticket.length) answer.add(ans);
        for(int i=0; i<ticket.length; i++){
            if(visited[i]) continue;
            if(ticket[i][0].equals(start)){
                boolean[] visit = Arrays.copyOf(visited,visited.length);
                visit[i]=true;
                dfs(ticket[i][1],visit,ans+ticket[i][1]+" ",depth+1);
            }
        }
        
    }
}