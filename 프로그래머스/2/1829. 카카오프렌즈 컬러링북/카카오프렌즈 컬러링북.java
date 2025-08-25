import java.util.*;
class Solution {
    int[][] map;
    boolean[][] visited;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int R;
    int C;
    int type=0;
    int max=0;
    int size=1;
    public int[] solution(int m, int n, int[][] picture) {
        
        int[] answer = new int[2];
        R=m;
        C=n;
        map = new int[m][n];
        visited = new boolean[m][n];
        map = picture;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]!=0 && !visited[i][j]) {
                    size=1;
                    visited[i][j]=true;
                    dfs(map[i][j],i,j);
                    type++;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        answer[0] = type;
        answer[1] = max;
        return answer;
    }
    public void dfs(int col, int r, int c){
        //if(r<0 || c>0 || r>=R|| c>=C) return;
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nc<0 || nr>=R|| nc>=C) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc]!=col||map[nr][nc]==0) continue;
            visited[nr][nc]=true;
            size++;
            dfs(col,nr,nc);
        }
        
        if(max<size) max=size;
    }
}