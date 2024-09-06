import java.util.*;
class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[] ans = new int[row_end-row_begin+1];
        Arrays.sort(data, (d1,d2)->{
            if(d1[col-1]==d2[col-1]){
                return d2[0]-d1[0];
            }
            else{
                return d1[col-1]-d2[col-1];
            }
        });
        int k=0;
        for(int i=row_begin-1; i<row_end; i++){
            for(int j=0; j<data[0].length; j++){
                ans[k]+=data[i][j]%(i+1);
            }
            k++;
        }
        
        for(int i=0; i<ans.length; i++){
            answer=ans[i]^answer;
        }
        return answer;
    }
}