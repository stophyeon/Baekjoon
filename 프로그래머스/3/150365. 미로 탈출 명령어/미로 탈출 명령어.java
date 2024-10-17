import java.util.*;
class Solution {
    String answer = "";
    int N, M;
    int K, R, C;
    int[] dr = {1,0,0,-1};
    int[] dc = {0,-1,1,0};
    String[] p = {"d","l","r","u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N=n;
        M=m;
        R=r;
        C=c;
        K=k;
        dfs(0, x, y,"");
        if(answer.equals("")) return "impossible";
        return answer;
    }
    public void dfs(int depth, int r, int c, String path){
        if(!answer.equals("")) return;
        if(depth==K){
            if(r==R && c==C) answer=path;
            return;
        }
        if(Math.abs(R-r)+Math.abs(C-c)>K-depth) return;
        if((K-depth-(Math.abs(R-r)+Math.abs(C-c)))%2!=0) return;
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(!inRange(nr,nc)) continue;
            dfs(depth+1, nr,nc,path+p[i]);
        }
    }
    
    //u-0, d-1, l-2, r-3
    public boolean inRange(int r, int c){
        return r>=1&&r<N+1&&c>=1&&c<M+1;
    }
}