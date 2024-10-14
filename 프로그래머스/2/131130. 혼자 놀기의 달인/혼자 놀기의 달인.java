class Solution {
    int answer = 0;
    int[] card;
    public int solution(int[] cards) {
        card=cards;
        for(int i=0; i<cards.length; i++){
            boolean[] visited = new boolean[cards.length];
            visited[i]=true;
            dfs(i+1,visited,1);
        }
        
        return answer;
    }
    public void dfs(int idx, boolean[] visited,int cnt){
        System.out.print(idx);
        System.out.print(",");
        if(visited[card[idx-1]-1]){
            for(int i=0; i<card.length; i++){
                if(visited[i]) continue;
                visited[i]=true;
                dfs2(i+1,visited,cnt,1);
            }
            return;
        }
        visited[card[idx-1]-1]=true;
        dfs(card[idx-1],visited,cnt+1);
    }
    
    public void dfs2(int idx, boolean[] visited,int cnt1,int cnt2){
        if(visited[card[idx-1]-1]){
            answer=Math.max(answer,cnt1*cnt2);
            return;
        }
        visited[card[idx-1]-1]=true;
        dfs2(card[idx-1],visited,cnt1,cnt2+1);
    }
}