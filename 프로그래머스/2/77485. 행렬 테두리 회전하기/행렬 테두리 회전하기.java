import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j]=(i-1)*columns+j;
            }
        }
        int idx=0;
        for(int[] q : queries){
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];
            int n = r2-r1+1;
            int m = c2-c1+1;
            int[] right = new int[2*n+2*(m-2)];
            int r=0;
            int c=0;
            int cnt=0;
            while(cnt!=2*n+2*(m-2)){
                right[cnt]=map[r1+r][c1+c];
                if(cnt< m-1) c++;
                if(cnt>=m-1 && cnt<n+m-2) r++;
                if(cnt>=n+m-2 && cnt<n+2*m-3) c--;
                if(cnt>=n+2*m-3 && cnt<2*n+2*m-4) r--;
                cnt++;
            }
            answer[idx]= Arrays.stream(right).min().getAsInt();
            map[r1][c1]=right[right.length-1];
            r=0;
            c=1;
            cnt=0;
            while(cnt!=2*n+2*(m-2)-1){
                map[r1+r][c1+c]=right[cnt];
                if(cnt< m-2) c++;
                if(cnt>=m-2 && cnt<n+m-3) r++;
                if(cnt>=n+m-3 && cnt<n+2*m-4) c--;
                if(cnt>=n+2*m-4 && cnt<2*n+2*m-5) r--;
                cnt++;
            }
            idx++;
            
        }
        
        return answer;
    }
}