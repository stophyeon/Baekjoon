import java.util.*;

class Solution {
    
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        HashMap<Integer,List<int[]>> graph = new HashMap<>();
        
        for(int[] cost : costs){
            if(!graph.containsKey(cost[0])){
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{cost[1],cost[2]});
                graph.put(cost[0],list);
                
            }
            else{
                graph.get(cost[0]).add(new int[]{cost[1],cost[2]});
            }
            if(!graph.containsKey(cost[1])){
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{cost[0],cost[2]});
                graph.put(cost[1],list);
            }
            else{
                graph.get(cost[1]).add(new int[]{cost[0],cost[2]});
            }
        }
        //간선 오름차순 정렬
        for(int key : graph.keySet()){
            Collections.sort(graph.get(key),(p1,p2)->p1[1]-p2[1]);
        }
        
        //시작노드는 아무거나 선택
        //for(int key : graph.keySet()){
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)-> p1[1] - p2[1]);
            //현재노드 번호, 누적 비용 저장
            for(int[] land : graph.get(costs[0][0])){
                pq.add(new int[]{land[0], land[1]});
            }
            HashSet<Integer> visited = new HashSet<>();
            visited.add(costs[0][0]);
            
            while(!pq.isEmpty()){
                int[] nd = pq.poll();
                //if(visited.size()==n) break;
                if(visited.contains(nd[0])) continue;
                answer+=nd[1];
                visited.add(nd[0]);
                for(int[] list : graph.get(nd[0])){
                    if(visited.contains(list[0])) continue;
                    pq.add(new int[]{list[0], list[1]});
                }

            }
        //}
        
        return answer;
    }
}