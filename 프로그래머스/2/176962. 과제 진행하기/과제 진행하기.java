import java.util.*;
class Solution {
    public class Plan{
        String name;
        int time;
        public Plan(String name, int time){
            this.name=name;
            this.time=time;
        }
    }
    HashMap<Integer,Plan> map = new HashMap<>();
    List<Integer> next = new ArrayList<>();
    Stack<Plan> st = new Stack<>();
    public String[] solution(String[][] plans) {
        
        String[] answer = new String[plans.length];
        String ans="";
        for(int i=0; i<plans.length; i++){
            String[] time = plans[i][1].split(":");
            int h = Integer.parseInt(time[0])*60;
            int m = Integer.parseInt(time[1]);
            next.add(h+m);
            map.put(h+m,new Plan(plans[i][0],Integer.parseInt(plans[i][2])));
        }
        Collections.sort(next,(t1,t2)->t1-t2);
        
        for(int i=0; i<next.size()-1; i++){
            int t=next.get(i);
            Plan p=map.get(next.get(i));
            if(p.time+next.get(i)==next.get(i+1)){
                ans+=p.name+",";
                continue;
            }
            else if(p.time+next.get(i)<next.get(i+1)){
                ans+=p.name+",";
                t+=p.time;
                if(!st.isEmpty()){
                    while(t<next.get(i+1)){
                        Plan rest = st.pop();
                        if(t+rest.time>next.get(i+1)){
                            rest.time-=next.get(i+1)-t;
                            st.push(rest);
                            break;
                        }
                        t+=rest.time;
                        ans+=rest.name+",";
                        if(st.isEmpty()) break;
                    }
                }
            }
            else{
                p.time-=next.get(i+1)-next.get(i);
                st.push(p);
            }
        }
        ans+=map.get(next.get(next.size()-1)).name+",";
        // answer[idx]=map.get(next.get(next.size()-1)).name;
        // idx++;
        while(!st.isEmpty()){
            Plan p = st.pop();
            ans+=p.name+",";
            // answer[idx]=p.name;
            // idx++;
        }
        System.out.println(ans);
        answer=ans.split(",");
        return answer;
    }
}