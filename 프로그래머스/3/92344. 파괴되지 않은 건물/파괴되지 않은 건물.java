class Solution {
    int[][] map;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        map= new int[board.length+1][board[0].length+1];
        for(int[] s : skill){
            //공격
            if(s[0]==1){
                map[s[1]][s[2]]+=-1*s[5];
                map[s[1]][s[4]+1]+=s[5];
                map[s[3]+1][s[2]]+=s[5];
                map[s[3]+1][s[4]+1]+=-1*s[5];
            }
            //회복
            else{
                map[s[1]][s[2]]+=s[5];
                map[s[1]][s[4]+1]+=-1*s[5];
                map[s[3]+1][s[2]]+=-1*s[5];
                map[s[3]+1][s[4]+1]+=s[5];
            }
        }
        for(int j=0; j<board[0].length+1; j++){
            for(int i=1; i<board.length+1; i++){
                map[i][j]+=map[i-1][j];
            }
        }
        for(int i=0; i<board.length+1; i++){
            for(int j=1; j<board[0].length+1; j++){
                map[i][j]+=map[i][j-1];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j]+=map[i][j];
                if(board[i][j]>0) answer++;
            }
        }
        return answer;
    }
}