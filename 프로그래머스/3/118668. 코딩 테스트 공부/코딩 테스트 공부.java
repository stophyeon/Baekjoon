import java.util.*;
class Solution {
    class State{
        private int alp;
        private int cop;
        private int time;
        
        public State(int alp,int cop, int time){
            this.alp=alp;
            this.cop=cop;
            this.time=time;      
        }
    }
    
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp =0;
        int maxCop =0;
        for(int[] p : problems){
            if(maxAlp<p[0]) maxAlp=p[0];
            if(maxCop<p[1]) maxCop=p[1];
        }
        alp=Math.min(maxAlp,alp);
        cop=Math.min(maxCop,cop);
        boolean[][] visited = new boolean[maxAlp+1][maxCop+1];
        PriorityQueue<State> pq = new PriorityQueue<>((s1,s2)->s1.time-s2.time);
        pq.add(new State(alp,cop,0));
        
        while(!pq.isEmpty()){
            State s = pq.poll();
            if(visited[s.alp][s.cop]){continue;}
            visited[s.alp][s.cop]=true;
            if(s.alp>=maxAlp && s.cop>=maxCop){return s.time;}
            for(int[] p : problems){
                if(s.alp>=p[0]&&s.cop>=p[1]){
                    pq.add(new State(Math.min(maxAlp,s.alp+p[2]),Math.min(maxCop,s.cop+p[3]),s.time+p[4]));
                }
            }
            pq.add(new State(Math.min(maxAlp,s.alp+1),Math.min(maxCop,s.cop),s.time+1));
            pq.add(new State(Math.min(maxAlp,s.alp),Math.min(maxCop,s.cop+1),s.time+1));   
        }
        return 0;
    }
}