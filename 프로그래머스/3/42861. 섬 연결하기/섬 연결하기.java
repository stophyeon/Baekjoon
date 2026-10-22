import java.util.*;

class Solution {
    HashMap<Integer,Integer> parent = new HashMap<>();
    public int solution(int n, int[][] costs) {
        //MST - 최소비용으로 순환없이 모두 이어지게 하는 알고리즘
        //크루스칼 - 간선중심
        //UNION-FIND - 노드중심
        // 1. 간선 비용 오름차순으로 정렬
        // 2. 간선 선택하면서 순환 발생 시 버림 
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[2]-p2[2]);
        for(int[] cost : costs){
            pq.add(cost);
            parent.put(cost[0],cost[0]);
            parent.put(cost[1],cost[1]);
        }
        
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            if(find(edge[1])!=find(edge[0])) {
                union(edge[0],edge[1]);
                answer+=edge[2];
            }
        }
        return answer;
    }
    
    public int find(int nd){
        if(parent.get(nd)==nd) return nd;
        parent.put(nd,find(parent.get(nd)));
        return parent.get(nd);
    }
    
    public void union(int a, int b){
        parent.put(find(b),find(a));
    }
}