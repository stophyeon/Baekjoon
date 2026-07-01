import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        //우선순위 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<priorities.length; i++){
            q.add(new int[]{i,priorities[i]});
            pq.add(priorities[i]);
            
        }
        int turn = 1;
        while(!q.isEmpty()){
            int[] pr = q.poll();
            int seq = pq.poll();
            if(pr[1]==seq){
                if(pr[0]==location) break;
                turn++;
            }
            else{
                q.add(pr);
                pq.add(seq);
            }
        }
        return turn;
    }
}