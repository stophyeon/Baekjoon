class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] prefix = new int[n+1][m+1];
        
        //skill 적용
        for(int[] s : skill){
            if(s[0]==1){
                prefix[s[1]][s[2]]+=-1*s[5];
                prefix[s[1]][s[4]+1]+= s[5];
                prefix[s[3]+1][s[2]]+= s[5];
                prefix[s[3]+1][s[4]+1]+= -1*s[5];
            }
            else{
                prefix[s[1]][s[2]]+=s[5];
                prefix[s[3]+1][s[2]]+= -1*s[5];
                prefix[s[1]][s[4]+1]+= -1*s[5];
                prefix[s[3]+1][s[4]+1]+=s[5];
            }
        }
        //누적합
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                prefix[i][j] += prefix[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefix[i][j] += prefix[i][j - 1];
            }
        }
        //파괴된 건물 개수 카운팅
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j]+=prefix[i][j];
                if(board[i][j]>0) answer++;
                //System.out.print(board[i][j]);
            }
            //System.out.println("");
        }
        return answer;
    }
    
}