import java.util.*;
class Work{
    String name;
    int start;
    int rest;
    public Work(String name, int start, int rest){
        this.name=name;
        this.rest=rest;
        this.start=start;
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        PriorityQueue<Work> pq = new PriorityQueue<>((p1,p2)->p1.start-p2.start);
        Stack<Work> remain = new Stack<>();
        
        for(String[] plan : plans){
            String[] s = plan[1].split(":");
            pq.add(new Work(plan[0],Integer.parseInt(s[0])*60+Integer.parseInt(s[1]),Integer.parseInt(plan[2])));
        }
        
        Work now = null;
        int idx=0;
        while(!pq.isEmpty()){
            Work next = pq.poll();
            if(now!=null){
                int t = next.start-now.start;
                //다음 과제 시작시간에 현재 과제가 안끝났을 경우
                if(now.rest>t){
                    remain.push(new Work(now.name,now.start,now.rest-t));
                }
                //다음 과제 시작시간에 현재 과제가 끝났을 경우
                else if(now.rest==t){
                    answer[idx]=now.name;
                    idx++;
                }
                //다음 과제 시작시간 전에 현재 과제가 끝났을 경우
                else{
                    answer[idx]=now.name;
                    idx++;
                    //Stack의 남아있는 과제를 함
                    int r = 0;
                    while(!remain.isEmpty()){
                        Work rt = remain.peek();
                        if(t<now.rest+r+rt.rest) {
                            rt.rest -= t-now.rest-r;
                            break;
                        }
                        r+=rt.rest;
                        answer[idx]=rt.name;
                        idx++;
                        remain.pop();
                    }
                }
            }
            now=next;
        }
        if(now!=null){
            answer[idx]=now.name;
            idx++;
        }
        //새로운 과제 모두 받은 후 남아있는 과제 처리
        while(!remain.isEmpty()){
            Work next = remain.pop();
            answer[idx]=next.name;
            idx++;
        }
        return answer;
    }
}