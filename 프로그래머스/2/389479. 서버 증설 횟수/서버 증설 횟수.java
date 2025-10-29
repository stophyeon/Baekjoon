import java.util.*;
class Solution {
    int answer = 0;
    //int[] player;
    //int limit;
    
    public int solution(int[] players, int m, int k) {
        //player = players;
        //limit = m;
        int server=0;
        //int time=0;
        Queue<Integer> q = new LinkedList<>();
        for(int player : players){
            int cnt=0;
            //System.out.print(q.size()+",");
            while(cnt!=server&&q.size()!=0){
                int s = q.poll();
                //System.out.print(s+",");
                if(s!=1) q.add(s-1);
                cnt++;
            }
            server=q.size();
            
            int need = player/m;
            
            //증설해야할 때
            if(server<need){
                answer+=(need-server);
                //time+=(need-server)*k;
                for(int i=0; i<need-server; i++) {q.add(k);}
                server=need;
            }
            //System.out.print(server +","+need);
            //System.out.println();
        }
        return answer;
    }
}