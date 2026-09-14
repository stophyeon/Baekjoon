import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        //입국심사 인원 n, 각 심사관별 심사시간 times[]
        //다음 사람은 비어있는 곳 or 더 빨리 끝나는 심사대 선택
        //기다리는 시간 + 심사시간 < 비어있는 곳 심사시간인지 확인
        long answer = Long.MAX_VALUE;
        long first = 1L;
        long end = 10000000000000L;
        long mid = (first+end)/2;
        while(first<=end){
            long cnt=0L;
            for(int t : times){
                cnt+=mid/t;
            }
            if(cnt>=n){
                answer = Math.min(answer,mid);
                end = mid-1;
            }
            else{
                first = mid+1;
            }
            mid = (first+end)/2;
        }
        return answer;
    }
}