import java.util.*;
class Solution {
    
    public int[][] map;
    public int[] dr = {1,0,0,-1};
    public int[] dc = {0,-1,1,0};
    public String[] pd = {"d","l","r","u"};
    public class Node{
        int r;
        int c;
        String path;
        int d;
        public Node(int r, int c,String path,int d){
            this.r=r;
            this.c=c;
            this.d=d;
            this.path=path;
        }
    }
    public String answer="";
    public int N;
    public int M;
    public boolean stop=false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map=new int[n][m];
        N=n;
        M=m;
        map[r-1][c-1]=1;
        int er =r-1;
        int ec=c-1;
        int dis = Math.abs(x-r)+Math.abs(y-c);
        //if((k-dis)%2==1) return "impossible";
        
        dfs(x-1,y-1,0,er,ec,"",k);
        if(answer.equals("")) return "impossible";
        return answer;
    }
    
    public boolean inRange(int r, int c){
        return r>=0&&r<N&&c>=0&&c<M;
    }
    
    public void dfs(int r, int c, int cnt, int er, int ec, String path,int k){
        if(!answer.equals("")) return;
        if(cnt==k&&r==er&&c==ec) {
            answer=path;
            return;
        }
        int d = Math.abs(r-er)+Math.abs(c-ec);
        if(d>k-cnt) return;
        if((k-cnt-d)%2!=0) return;
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(!inRange(nr,nc)) continue;
            
            dfs(nr,nc,cnt+1,er,ec,path+pd[i],k);
        }
    }
}