import java.util.*;
class Solution {
    int[][] map;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int answer = Integer.MAX_VALUE;
    boolean[][] visitedRed;
    boolean[][] visitedBlue;
   
    public int solution(int[][] maze) {
        int red_start_r=0;
        int red_start_c=0;
        int blue_start_r=0;
        int blue_start_c=0;
        map=maze;
        visitedRed = new boolean[maze.length][maze[0].length];
        visitedBlue = new boolean[maze.length][maze[0].length];
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                if(maze[i][j]==1){
                    red_start_r=i;
                    red_start_c=j;
                    visitedRed[i][j]=true;
                }
                if(maze[i][j]==2){
                    blue_start_r=i;
                    blue_start_c=j;
                    visitedBlue[i][j]=true;
                }
                
                
            }
        }
        dfs(red_start_r,red_start_c,blue_start_r,blue_start_c,0);
        if(answer==Integer.MAX_VALUE) return 0;
        return answer;
    }
    public void dfs(int rr, int rc, int br, int bc,int turn){
        
        if(map[rr][rc]==3&&map[br][bc]==4){
            if(answer>turn) answer=turn;
            return;
        }
        if(map[rr][rc]==3){
            for(int i=0; i<4; i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];
                if(inRange(nr,nc)&&!visitedBlue[nr][nc]&&map[nr][nc]!=5){
                    if(!(nr==rr&&nc==rc)){
                        visitedBlue[nr][nc]=true;
                        dfs(rr,rc,nr,nc,turn+1);
                        visitedBlue[nr][nc]=false;    
                    }
                }
            }
        }
        else if(map[br][bc]==4){
            for(int i=0; i<4; i++){
                int nr=rr+dr[i];
                int nc=rc+dc[i];
                if(inRange(nr,nc)&&!visitedRed[nr][nc]&&map[nr][nc]!=5){
                    if(!(nr==br&&nc==bc)){
                        visitedRed[nr][nc]=true;
                        dfs(nr,nc,br,bc,turn+1);
                        visitedRed[nr][nc]=false;
                    }
                }
            }
        }
        else{
            for(int i=0; i<4; i++){
                int nrr=rr+dr[i];
                int ncr=rc+dc[i];
                if(inRange(nrr,ncr)&&!visitedRed[nrr][ncr]&&map[nrr][ncr]!=5){
                    for(int j=0; j<4; j++){
                        int nrb=br+dr[j];
                        int ncb=bc+dc[j];
                        if(inRange(nrb,ncb)&&!visitedBlue[nrb][ncb]&&map[nrb][ncb]!=5){
                            if(!(nrr==br&&ncr==bc&&nrb==rr&&ncb==rc)){
                                if(!(nrr==nrb&&ncr==ncb)){
                                    visitedBlue[nrb][ncb]=true;
                                    visitedRed[nrr][ncr]=true;
                                    dfs(nrr,ncr,nrb,ncb,turn+1);
                                    visitedRed[nrr][ncr]=false;
                                    visitedBlue[nrb][ncb]=false;
                                }
                            }
                            
                        }
                    }
                }
            }
        }
    }    
    public boolean inRange(int r, int c){
        return r>=0 && r<map.length &&c>=0 && c<map[0].length;
    }
}