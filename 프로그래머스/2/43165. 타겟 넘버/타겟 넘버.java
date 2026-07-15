import java.util.*;

class Solution {
    int len, answer = 0;
    int[] num;
    int trg;
    public int solution(int[] numbers, int target) {
        trg=target;
        len=numbers.length;
        num = numbers;
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int idx, int res){
        if(idx==len){
            if(res==trg) answer++;
            return;
        }
        dfs(idx+1,num[idx]+res);
        dfs(idx+1,(num[idx]*-1)+res); 
    }
}