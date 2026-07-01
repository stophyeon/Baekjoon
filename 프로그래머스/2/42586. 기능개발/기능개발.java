import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        //개발 완료 일수 
        for(int i =progresses.length-1; i>=0; i--) {
            int day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) day++;
            st.push(day);
        }
        while(!st.isEmpty()){
            int size=st.size();
            //1개 남았을 때
            if(size==1) {
                answer.add(1);
                break;
            }
            int max = st.pop();
            int next = st.pop();
            
            //뒤에 작업이 이미 완료
            if(max>=next){
                while(!st.isEmpty()){
                    max=Math.max(max,next);
                    next = st.pop();
                    if(max<next) {st.push(next); break;}
                }
            }
            //앞에 작업만 완료됐으면 1개만 배포
            else{
                st.push(next);
            }
            
            answer.add(size-st.size());
        }
       
        return answer.stream().mapToInt(i -> i).toArray();
    }
}