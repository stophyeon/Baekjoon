import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int[][] box = new int[(n/w)+1][w];
        int r = box.length-1;
        int c = 0;
        int right = 1;
        int dr = 0;
        int dc = 0;
        for(int i = 1; i<=n; i++){
            box[r][c]= i;
            if(i==num){
                dr=r;
                dc=c;
            }
            c+=right;
            //오른쪽으로 끝까지 감
            if(c==w){
                r-=1;
                c-=1;
                right=-1;
            }
            //왼쪽끝까지감
            if(c==-1){
                r-=1;
                c+=1;
                right=1;
            }
        }
        //System.out.println(dr+","+dc);
        for(int i=0; i<dr; i++){
            //System.out.println(box[i][c]);
            if(box[i][dc]!=0) answer++;
        }
        return answer;
    }
}