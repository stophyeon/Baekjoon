import java.util.*;
class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int ix;
    int iy;
    int answer = Integer.MAX_VALUE;
    int[][] map=new int[102][102];
    int[][] loc;
    public class Node{
        int x;
        int y;
        int d;
        public Node(int x, int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        ix=itemX*2;
        iy=itemY*2;
        loc=new int[rectangle.length][4];
        int cnt=0;
        for(int[] rec : rectangle){
            loc[cnt][0]=rec[0]*2+1;
            loc[cnt][1]=rec[2]*2-1;
            loc[cnt][2]=rec[1]*2+1;
            loc[cnt][3]=rec[3]*2-1;
            for(int i=rec[0]*2; i<=rec[2]*2; i++){
                map[rec[1]*2][i]=1;
                map[rec[3]*2][i]=1;
            }
            
            for(int i=rec[1]*2; i<=rec[3]*2; i++){
                map[i][rec[0]*2]=1;
                map[i][rec[2]*2]=1;
            }
            cnt++;
        }
        
        for(int[] l : loc){
            for(int i=l[0]; i<=l[1]; i++){
                for(int j=l[2]; j<=l[3]; j++){
                    map[j][i]=0;
                }
            }
        }
        //for(int i=0; i<50; i++){
        //    for(int j=0; j<50; j++){
        //        System.out.print(map[i][j]);
        //       System.out.print(" ");
        //    }
        //    System.out.println();
        //}
        bfs(characterX*2,characterY*2);
        return answer/2;
    }
    public void bfs(int x, int y){
        boolean[][] visited = new boolean[102][102];
        visited[y][x]=true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.x==ix && n.y==iy) {answer=n.d; break;}
            for(int i=0; i<4; i++){
                int nx = n.x+dx[i];
                int ny = n.y+dy[i];
                if(visited[ny][nx]) continue;
                if(map[ny][nx]==0) continue;
                visited[ny][nx]=true;
                q.add(new Node(nx,ny,n.d+1));
            }
        }
    }
}