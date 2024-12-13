class Solution {
    int[][] map;
    int[][] prefix;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        map=board;
        int n=board.length;
        int m=board[0].length;
        prefix=new int[n+1][m+1];
        for(int[] s : skill){
            if(s[0]==1){
                attack(s[1],s[2],s[3],s[4],s[5]*(-1));
            }
            else{
                hill(s[1],s[2],s[3],s[4],s[5]);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                prefix[j][i]+=prefix[j-1][i];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                prefix[i][j]+=prefix[i][j-1];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j]+=prefix[i][j];
                if(map[i][j]>0) answer++;
            }
        }
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(prefix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    public void attack(int r1, int c1, int r2, int c2, int d){
        prefix[r1][c1]+=d;
        prefix[r1][c2+1]-=d;
        prefix[r2+1][c1]-=d;
        prefix[r2+1][c2+1]+=d;
    }
    public void hill(int r1, int c1, int r2, int c2, int d){
        prefix[r1][c1]+=d;
        prefix[r1][c2+1]-=d;
        prefix[r2+1][c1]-=d;
        prefix[r2+1][c2+1]+=d;
    }
}