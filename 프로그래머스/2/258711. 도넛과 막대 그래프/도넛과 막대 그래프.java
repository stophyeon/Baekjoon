import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer,int[]> vertex = new HashMap<>();
        int max=0;
        int num=0;
        for(int[] edge :edges){
            if(max<edge[0]) max=edge[0];
            if(max<edge[1]) max=edge[1];
        }
        
        int[] in = new int[max+1];
        int[] out = new int[max+1];
        
        for(int[] edge :edges){
            in[edge[1]]+=1;
            out[edge[0]]+=1;
        }
        for(int i=1; i<=max; i++){
            if(in[i]==0&&out[i]>=2) {answer[0]=i;num=out[i];break;}
        }
        
        for(int i=1; i<=max; i++){
            //막대
            if(in[i]>=1&&out[i]==0) answer[2]+=1;
            //8자
            if(in[i]>=2&&out[i]==2) answer[3]+=1;
                
        }
        answer[1]=num-answer[2]-answer[3];
        return answer;
    }
}