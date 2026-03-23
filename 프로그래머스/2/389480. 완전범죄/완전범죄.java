import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int N;
    int M;
    int len;
    int[][] map;
    public int solution(int[][] info, int n, int m) {
        M=m;
        N=n;
        len = info.length;
        map = info;
        comb(new boolean[len][N][M],0,0,0);
        if(answer == Integer.MAX_VALUE) answer=-1;
        return answer;
    }
    
    public void comb(boolean[][][] visited, int cntA, int cntB, int depth){
        //흔적이 기준 이상일 때
        if(cntA >= N || cntB >= M) return;
        //물건 모두 훔쳤을 때
        if(depth==len){
            answer = Math.min(answer,cntA);
            return;
        }
        
        if(cntA+map[depth][0]<N && !visited[depth][cntA+map[depth][0]][cntB]){
            //A가 흠친 경우    
            visited[depth][cntA+map[depth][0]][cntB]=true;
            comb(visited,cntA+map[depth][0],cntB,depth+1);
        }
        if(cntB+map[depth][1]<M && !visited[depth][cntA][cntB+map[depth][1]]){
            //B가 흠친 경우    
            visited[depth][cntA][cntB+map[depth][1]]=true;
            comb(visited,cntA,cntB+map[depth][1],depth+1);
        }
    }
}