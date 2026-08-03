import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)->p1-p2);
        for(int s : scoville)
            pq.add(s);
        int cnt = 0;
        while(!pq.isEmpty()){
            int s = pq.poll();
            if(s>=K) continue;
            else{
                if(pq.isEmpty())
                    return -1;
                else{
                    int next = pq.poll();
                    pq.add(s+next*2);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}