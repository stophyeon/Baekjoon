import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 1;
        //규칙이 지켜졌는지 여부 확인
        //규칙 - 선공 O, 후공 X, 가로세로대각선 빙고면 게임 중단
        int[][] map = new int[3][3];
        int oCnt=0;
        int xCnt=0;
        for(int i=0; i<3; i++){
            String[] r = board[i].split("");
            for(int j=0; j<3; j++){
                if(r[j].equals(".")) map[i][j]=0;
                else if(r[j].equals("O")) {map[i][j]=1; oCnt++;}
                else if(r[j].equals("X")) {map[i][j]=2; xCnt++;}
            }
        }
        //X개수가 O개수 이하인지, O개수-X개수<=1인지
        if(oCnt-xCnt>1 || xCnt>oCnt) return 0;
        //가로,세로,대각선에 같은 모양이 1개 이하인지
        int obingo = 0;
        int xbingo = 0;
        int now1=map[0][0];
        int now2=map[0][2];
        int cnt1=0;
        int cnt2=0;
        
        for(int i=0; i<3; i++){
            if(map[i][0]!=0&&map[i][0]==map[i][1] && map[i][1]==map[i][2]) {
                if(map[i][0]==1) obingo++;
                if(map[i][0]==2) xbingo++;
            }
            if(map[0][i]!=0&&map[0][i]==map[1][i] && map[1][i]==map[2][i]) {
                if(map[0][i]==1) obingo++;
                if(map[0][i]==2) xbingo++;
                
            }
            if(now1!=0 && now1==map[i][i]) cnt1++;
            if(now2!=0 && now2==map[i][2-i]) cnt2++;
        }
        if(cnt1==3) {
            if(map[0][0]==1) obingo++;
            if(map[0][0]==2) xbingo++;
        }
        if(cnt2==3) {
            if(map[0][2]==1) obingo++;
            if(map[0][2]==2) xbingo++;
        }
        if(obingo>=1) 
            if(oCnt!=xCnt+1)
                answer=0;
        if(xbingo>=1) 
            if(oCnt!=xCnt)
                answer=0;
        return answer;
    }
}