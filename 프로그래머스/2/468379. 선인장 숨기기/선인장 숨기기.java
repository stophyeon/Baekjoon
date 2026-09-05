import java.util.*;

class Solution {
    
    int H,W;
    int M,N;
    int[] answer = new int[2];
    List<int[]> drop = new ArrayList<>();
    boolean possible = false;
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int cnt = drops.length;
        
        H=h;
        W=w;
        M=m;
        N=n;
        for(int[] d : drops){
            drop.add(d);
        }
        //비를 안맞을 수 있는 구역탐색
        //이분탐색으로 해당 시간에 비를 안맞는 구역이 있는지 탐색
        int s=0;
        int e=drops.length;
        
        while(s<=e){
            int mid = (s+e)/2;
            //해당 시간까지 비가 안맞는 구역이 있음
            if(check(mid)){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return answer;
    }
    
    public boolean check(int mid){
        int[][] map = new int[M][N];
        int[][] sum = new int[M+1][N+1];
        for(int i=0; i<mid; i++){
            int[] pos = drop.get(i);
            map[pos[0]][pos[1]]=1;
        }
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                sum[i][j] = map[i-1][j-1]+sum[i-1][j]-sum[i-1][j-1]+sum[i][j-1];
            }    
        }
        for(int i=1; i<=M-H+1; i++){
            for(int j=1; j<=N-W+1; j++){
                int r = i+H-1;
                int c = j+W-1;
                int res = sum[r][c]-sum[i-1][c]-sum[r][j-1]+sum[i-1][j-1];
                //비를 안맞은 곳 있음
                if(res==0){
                    answer=new int[]{i-1,j-1};
                    return true;
                }
            }    
        }
        return false;
    }
    
}