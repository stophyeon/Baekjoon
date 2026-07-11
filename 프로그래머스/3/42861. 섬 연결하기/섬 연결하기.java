import java.util.*;
class Node{
    int num;
    int cost;
    public Node(int num, int cost){
        this.num=num;
        this.cost=cost;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        
        int answer = Integer.MAX_VALUE;
        HashMap<Integer,List<Node>> map = new HashMap<>();
        //간선 정보 저장
        for(int[] c : costs){
            if(map.containsKey(c[0])){
                map.get(c[0]).add(new Node(c[1],c[2]));
            }
            else{
                List<Node> list = new ArrayList<>();
                list.add(new Node(c[1],c[2]));
                map.put(c[0],list);
            }
            if(map.containsKey(c[1])){
                map.get(c[1]).add(new Node(c[0],c[2]));
            }
            else{
                List<Node> list = new ArrayList<>();
                list.add(new Node(c[0],c[2]));
                map.put(c[1],list);
            }
            
        }
       
        
        int[][] dist = new int[100][100];
        for(int start : map.keySet()){
            boolean[] visited = new boolean[100]; 
            //[섬 번호, cost]
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[1]-p2[1]);
            pq.add(new int[]{start,0});
            while(!pq.isEmpty()){
                int[] nd = pq.poll();
                visited[nd[0]]=true;
                for(Node next : map.get(nd[0])){
                    if(visited[next.num]) continue;
                    if(dist[start][next.num]==0 || dist[start][next.num]>next.cost){
                        dist[start][next.num]=next.cost;
                        pq.add(new int[]{next.num,next.cost});
                    }

                }
            }
        }
        
        for(int start : map.keySet()){
            int total=0;
            for(int i=0; i<dist.length; i++){
                if(dist[start][i]!=0) total+=dist[start][i];
                
            }    
            if(answer>total) answer = total;
        }
        
        return answer;
    }
}