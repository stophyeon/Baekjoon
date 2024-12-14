import java.util.*;
class Solution {
    int n;
    int m;
    int[][] map;
    public class Node{
        int r;
        int c;
        int time;
        public Node(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        int sr=0;
        int sc=0;
        int lr=0;
        int lc=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)=='S') {sr=i; sc=j;}
                else if(maps[i].charAt(j)=='E') map[i][j]=3;
                else if(maps[i].charAt(j)=='L') {map[i][j]=2;lr=i;lc=j;}
                else if(maps[i].charAt(j)=='X') map[i][j]=1;
            }
        }
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        int l = findLever(sr,sc);
        if(l==0) return -1;
        int e = findEscape(lr,lc);
        if(e==0) return -1;
        return l+e;
    }
    public int findLever(int sr, int sc){
        int total=0;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr,sc,0));
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            Node nd = q.poll();
            if(map[nd.r][nd.c]==2) {total=nd.time;break;} 
            for(int i=0; i<4; i++){
                int nr = nd.r+dr[i];
                int nc = nd.c+dc[i];
                if(!inRange(nr,nc)||visited[nr][nc]) continue;
                if(map[nr][nc]==1) continue;
                q.add(new Node(nr,nc,nd.time+1));
                visited[nr][nc]=true;
            }
        }
        return total;
    }
    
    public int findEscape(int sr, int sc){
        int total=0;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr,sc,0));
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            Node nd = q.poll();
            if(map[nd.r][nd.c]==3) {total=nd.time; break;} 
            for(int i=0; i<4; i++){
                int nr = nd.r+dr[i];
                int nc = nd.c+dc[i];
                if(!inRange(nr,nc)||visited[nr][nc]) continue;
                if(map[nr][nc]==1) continue;
                q.add(new Node(nr,nc,nd.time+1));
                visited[nr][nc]=true;
            }
        }
        return total;
    }
    
    public boolean inRange(int r, int c){
        return r>=0&&r<n&&c>=0&&c<m;
    }
}