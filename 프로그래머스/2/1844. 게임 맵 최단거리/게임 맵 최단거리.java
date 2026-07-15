import java.util.*;
public class Node{
    int r;
    int c;
    int dis;
    public Node(int r, int c, int dis){
        this.r=r;
        this.c=c;
        this.dis=dis;
    }
}
class Solution {
    int[] dr = {-1,0,0,1};
    int[] dc = {0,1,-1,0};
    int n,m;
    public int solution(int[][] maps) {
        int answer = -1;
        n=maps.length;
        m=maps[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.dis-n2.dis);
        //출발 - 0,0 도착 n-1,m-1
        pq.add(new Node(0,0,1));
        boolean[][] visited = new boolean[n][m];
        visited[0][0]=true;
        while(!pq.isEmpty()){
            Node nd = pq.poll();
            if(nd.r==n-1 && nd.c==m-1){
                answer = nd.dis;
                break;
            }
            for(int i=0; i<4; i++){
                int nr = nd.r+dr[i];
                int nc = nd.c+dc[i];
                if(!inRange(nr,nc)) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc]==0) continue;
                pq.add(new Node(nr,nc,nd.dis+1));
                visited[nr][nc]=true;
            }
        }
        return answer;
    }
    
    public boolean inRange(int r, int c){
        return r>=0&& c>=0 && r<n && c<m;
    }
}