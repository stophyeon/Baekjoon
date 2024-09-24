import java.util.*;
class Solution {
    int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int big = 1000000007;
        map=new int[n][m];
        for(int i=0; i<n; i++){
            map[i][0]=1;
        }
        for(int i=0; i<m; i++){
            map[0][i]=1;
        }
        for(int[] pd : puddles){
            map[pd[1]-1][pd[0]-1]=-1;
        }
        for(int i=0; i<n; i++){
            if(map[i][0]==-1){
                for(int j=i+1; j<n; j++){map[j][0]=0;}
            }
        }
        for(int i=0; i<m; i++){
            if(map[0][i]==-1){
                for(int j=i+1; j<m; j++){map[0][j]=0;}
            }
        }
        if(map[1][0]==-1&&map[0][1]==-1) return 0;
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(map[i][j]==-1) continue;
                if(map[i-1][j]==-1&&map[i][j-1]==-1) continue;
                if(map[i-1][j]==-1){
                    map[i][j]=map[i][j-1]%big;
                    continue;
                }
                if(map[i][j-1]==-1){
                    map[i][j]=map[i-1][j]%big;
                    continue;
                }
                else{map[i][j]=(map[i-1][j]+map[i][j-1])%big;}
            }
        }
        
        return map[n-1][m-1]%big;
    }
    
   
}