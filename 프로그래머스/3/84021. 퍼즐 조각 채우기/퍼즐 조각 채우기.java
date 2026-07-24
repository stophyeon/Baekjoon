import java.util.*;

class Solution {
    int N;
    List<int[][]> blockList = new ArrayList<>();
    List<int[][]> blankList = new ArrayList<>();
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int maxCnt = 0;
    int answer = 0;
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        //각 블록을 6X6 에 저장
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]||table[i][j]==0) continue;
                findBlock(i,j,table,visited);
            }    
        }
        
        boolean[][] visit = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j]||game_board[i][j]==1) continue;
                findBlank(i,j,game_board,visit);
            }    
        }
        
        // for(int[][] b : blank){
        //     for(int i=0; i<6; i++){
        //         for(int j=0; j<6; j++){
        //             System.out.print(b[i][j]);    
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        
        // blank, block 비교 후 딱 맞는 모양이 있으면 배치
        boolean[] visitBlank = new boolean[blankList.size()];
        boolean[] visitBlock = new boolean[blockList.size()];
        int[][] bl = new int[6][6];
        int[][] bk = new int[6][6];
        for(int i=0; i<blankList.size(); i++){
            if(visitBlank[i]) continue;
            bl = blankList.get(i);
            for(int j=0; j<blockList.size(); j++){
                if(visitBlock[j]) continue;
                bk = blockList.get(j);
                //모양이 맞을 때
                if(batch(bl,bk)){
                    answer+=getSize(bk);
                    visitBlank[i]=true;
                    visitBlock[j]=true;
                    break;
                }
            }    
        }
        
        return answer;
    }
    
    public boolean batch(int[][] bl,int[][] bk){
        if(isPossible(bl,bk)){
            return true;
        }
        //90,180,270 회전 비교
        for(int i=0; i<3; i++){
            bk = rotate(bk);
            if(isPossible(bl,bk)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isPossible(int[][] bl,int[][] bk){
        
        for(int i=0; i<bl.length; i++){
            for(int j=0; j<bl.length; j++){
                if(bl[i][j]==1 && bk[i][j]==0) return false;
                if(bl[i][j]==0 && bk[i][j]==1) return false;
            }    
        }
        return true;
    }
    
    public int[][] rotate(int[][] bk){
        //if(rx==0) return bk;
        int[][] rotate = new int[6][6];
        
        for(int k=0; k<bk.length; k++){
            for(int j=0; j<bk.length; j++){
                rotate[j][5-k] = bk[k][j];
            }    
        }
        
        //가장 왼쪽, 가장 위쪽에 있는 블록 찾가
        int minR=6;
        int minC=6;
        for(int i=0; i<rotate.length; i++){
            for(int j=0; j<rotate.length; j++){
                if(rotate[i][j]==1){
                    if(minR>i) minR=i;
                    if(minC>j) minC=j;    
                }
            }    
        }
        int[][] res = new int[6][6];
        for(int i=0; i<rotate.length; i++){
            for(int j=0; j<rotate.length; j++){
                if(rotate[i][j]==1)
                    res[i-minR][j-minC]=1;
            }    
        }
        return res;
    }
    
    public int getSize(int[][] bk){
        int cnt=0;
        for(int i=0; i<bk.length; i++){
            for(int j=0; j<bk.length; j++){
                if(bk[i][j]==1) cnt++;
            }    
        }
        return cnt;
    }
    
    public void findBlank(int r, int c, int[][] table, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> find = new ArrayList<>();
        int[][] bk = new int[6][6];
        q.add(new int[]{r,c});
        visited[r][c]=true;
        while(!q.isEmpty()){
            int[] nd = q.poll();
            find.add(new int[]{nd[0],nd[1]});
            for(int i=0; i<4; i++){
                int nr = nd[0]+dr[i];
                int nc = nd[1]+dc[i];
                if(!inRange(nr,nc)) continue;
                if(visited[nr][nc]||table[nr][nc]==1) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc]=true;
            }
        }
        //가장 왼쪽, 가장 위쪽에 있는 블록 찾가
        int minR=50;
        int minC=50;
        for(int[] b : find){
            if(minR>b[0]) minR=b[0];
            if(minC>b[1]) minC=b[1];
        }
        for(int[] b : find){
            bk[b[0]-minR][b[1]-minC]=1;
        }
        
        blankList.add(bk);
    }    
    public void findBlock(int r, int c, int[][] table, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> find = new ArrayList<>();
        int[][] bk = new int[6][6];
        q.add(new int[]{r,c});
        visited[r][c]=true;
        while(!q.isEmpty()){
            int[] nd = q.poll();
            find.add(new int[]{nd[0],nd[1]});
            for(int i=0; i<4; i++){
                int nr = nd[0]+dr[i];
                int nc = nd[1]+dc[i];
                if(!inRange(nr,nc)) continue;
                if(visited[nr][nc]||table[nr][nc]==0) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc]=true;
            }
        }
        //가장 왼쪽, 가장 위쪽에 있는 블록 찾가
        int minR=50;
        int minC=50;
        for(int[] b : find){
            if(minR>b[0]) minR=b[0];
            if(minC>b[1]) minC=b[1];
        }
        for(int[] b : find){
            bk[b[0]-minR][b[1]-minC]=1;
        }
        
        blockList.add(bk);
    }
    
    public boolean inRange(int r, int c){
        return r>=0 && c>=0 && r<N && c<N; 
    }
}