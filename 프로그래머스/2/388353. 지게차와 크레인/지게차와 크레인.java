import java.util.*;
class Solution {
    int n=0;
    int m=0;
    int cnt=0;
    String[][] map;
    HashMap<int[],Integer> res = new HashMap<>();
    
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new String[n][m];
        
        int answer = n*m;
        for(int i=0; i<storage.length; i++){
            map[i] = storage[i].split("");
        }
        
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        for(String req : requests){
            cnt=0;
            res.clear();
            boolean[][] visited = new boolean[n][m];
            visited[0][0] =true;
            dfs(req,0,0,visited);
            for(int[] pos : res.keySet()){
                map[pos[0]][pos[1]]=" ";
            }
            // for(int i=0; i<n; i++){
            //     for(int j=0; j<m; j++){
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            // System.out.println(cnt);
            answer-=cnt;
        }
        
        return answer;
    }
    
    public void dfs(String req, int r, int c,boolean[][] visited){
        
        if(map[r][c].equals(req.substring(0,1))){
            int[] pos = {r,c};
            if(!res.containsKey(pos)){
                res.put(pos,1);
                cnt++;    
            }
        }
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
            if(visited[nr][nc]) continue;
            visited[nr][nc] = true;
            if(req.length()==1){
                if(isPossible(nr,nc,i)) dfs(req, nr,nc, visited);
                else{visited[nr][nc] = false;}
            }
            else{
                dfs(req, nr,nc, visited);
            }
        }
    }
    
    public boolean isPossible(int r, int c,int i){
        if(r==0 || r == n-1 || c==0 || c==m-1) return true;
        if(map[r-dr[i]][c-dc[i]].equals(" ")) return true;
        return false;
    }
    
}