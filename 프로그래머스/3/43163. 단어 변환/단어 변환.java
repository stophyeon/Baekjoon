import java.util.*;

class Solution {
    public class Node{
        String s;
        int cnt;
        public Node(String s, int cnt){
            this.s=s;
            this.cnt=cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.cnt-n2.cnt);
        HashMap<String,Integer> visited = new HashMap<>();
        pq.add(new Node(begin,0));
        visited.put(begin,1);
        while(!pq.isEmpty()){
            Node nd = pq.poll();
            if(nd.s.equals(target)){
                answer=nd.cnt;
                break;
            }
            for(String w : words){
                if(!diff(nd.s,w)) continue;
                if(visited.containsKey(w)) continue;
                pq.add(new Node(w,nd.cnt+1));
                visited.put(w,1);
            }
        }
        return answer;
    }
    
    public boolean diff(String s1, String s2){
        int total=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                total++;
                if(total>1) return false;
            }
        }
        return true;
    }
}