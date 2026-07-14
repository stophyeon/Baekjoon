import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[0]-p2[0]);
        for(int[] r : routes){
            pq.add(r);
        }
        //구간 저장 - [구가시작점, 구간 끝나는 점]
        List<int[]> scope = new ArrayList<>();
        int[] start = pq.poll();
        scope.add(start);
        boolean plus = true;
        while(!pq.isEmpty()){
            int[] car = pq.poll();
            plus = true;
            for(int[] s : scope){
                //시작점이 카메라 구간안에 있을때
                if(car[0]>=s[0]&&car[0]<=s[1]){
                    //차 이동구간이 카메라 구간안에 있을때
                    if(car[1]>=s[0]&&car[1]<=s[1]){
                        s[0] = car[0];
                        s[1] = car[1];
                        plus = false;
                        break; 
                    }
                    else{
                        //카메라 대수 유지, 구간 재설정
                        s[0] = car[0];
                        plus = false;
                        break;    
                    }
                    
                }
                //카메라 구간이 차 이동구간안에 있을때
                else if(s[0]>=car[0]&&s[0]<=car[1]&&s[1]>=car[0]&&s[1]<=car[1]){
                    //카메라 대수 유지, 구간 
                    plus = true;
                    break;
                }
                //끝지점이 카메라 구간안에 있을때
                else if(car[1]>=s[0]&&car[1]<=s[1]){
                    //카메라 대수 유지, 구간 재설정
                    s[1] = car[1];
                    plus = false;
                    break;
                }
            }
            //시작점이 구간안에 없을때
            if(plus){
                //카메라 대수 +1, 새로운 구간 추가
                answer++;
                scope.add(new int[]{car[0],car[1]});
            }
        }
        
        return answer;
    }
}