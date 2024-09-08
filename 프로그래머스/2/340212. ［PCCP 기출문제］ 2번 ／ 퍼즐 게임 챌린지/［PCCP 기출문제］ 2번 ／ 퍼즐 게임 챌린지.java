import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        //퍼블난이도 diffs <= 내 레벨 -> time_cur만큼 사용하여 해결

        // diffs > level -> diffs-level 번 틀림. 
        //틀릴때마다 time_cur 시간 사용, time_prev 시간 사용하여 이전 퍼즐 다시 품 (이전 퍼즐은 무조건 풀 수 있음)
        //diffs-level 만큼 다 틀린 이후에 퍼즐을 풀면 time_cur 만큼 써서 퍼즐 해결

        //제한시간 limit 안에 모든 퍼즐을 해결하기 위한 level의 최솟값?


        answer = binarySearch(diffs, times, limit);

        return answer;
    }

    public static boolean checkSuccess(int[] diffs, int[] times, long limit, int level){

        long totalTime = 0;

        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= level){
                totalTime += times[i];
            }else{
                totalTime += (times[i]+times[i-1])*(diffs[i]-level) + times[i];
            }
        }

        return (totalTime <= limit) ? true : false;
    }

    public static int binarySearch(int[] diffs, int[] times, long limit){

        int top = Arrays.stream(diffs).max().orElseThrow();
        int down = 1;
        int middle = 0;

        while(down <= top){

            middle = (top+down)/2;

            if(checkSuccess(diffs, times, limit, middle)){
                top = middle -1;
            }else{
                down = middle +1;
            }

        }
        if(checkSuccess(diffs, times, limit, middle)){
            return middle;
        }else if(checkSuccess(diffs, times, limit, middle+1)){
            return middle+1;
        }else{
            return middle-1;
        }

    }
}