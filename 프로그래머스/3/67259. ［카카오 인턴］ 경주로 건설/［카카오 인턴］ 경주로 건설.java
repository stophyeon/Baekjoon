import java.util.*;
class Solution {
    public class Node{
        int r;
        int c;
        int d;
        int cost;
        
        public Node(int r, int c, int d,int cost){
            this.r=r;
            this.c=c;
            this.d=d;
            this.cost=cost;
        }
    }
    int len;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        len = board.length;
        PriorityQueue<Node> q = new PriorityQueue<>((n1,n2)->n1.cost-n2.cost);
        boolean[][][] visited = new boolean[len][len][4];
        q.add(new Node(0,0,-1,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.r==len-1&&n.c==len-1){
                answer=Math.min(answer,n.cost);
            }
            for(int i=0; i<4; i++){
                int nr = n.r+dr[i];
                int nc = n.c+dc[i];
                if(!inRange(nr,nc)) continue;
                if(board[nr][nc]==1) continue;
                int cost = n.cost;
                //직선
                if(n.d==-1 || n.d==i){
                    cost+=100;
                }
                //코너
                else{cost+=600;}
                if(!visited[nr][nc][i] || board[nr][nc]>=cost){
                    board[nr][nc]=cost;
                    visited[nr][nc][i]=true;
                    q.add(new Node(nr,nc,i,cost));
                }
                
            }
        }
        return answer;
    }
    
    public boolean inRange(int r, int c){
        return r>=0&&r<len&&c>=0&&c<len;
    }
}