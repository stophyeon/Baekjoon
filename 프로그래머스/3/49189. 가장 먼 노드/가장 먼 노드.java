import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //1~n 노드 중 1번 노드와 가장 멀리 떨어진 노드 갯수
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        HashMap<Integer,List<Integer>> edges = new HashMap<>();
        for(int[] e : edge){
            if(edges.containsKey(e[0])){
                edges.get(e[0]).add(e[1]);
            }
            if(!edges.containsKey(e[0])){
                List<Integer> list = new ArrayList<>();
                list.add(e[1]);
                edges.put(e[0],list);
            }
            if(edges.containsKey(e[1])){
                edges.get(e[1]).add(e[0]);
            }
            if(!edges.containsKey(e[1])){
                List<Integer> list = new ArrayList<>();
                list.add(e[0]);
                edges.put(e[1],list);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        //[노드번호, 거리]
        q.add(new int[]{1,0});
        boolean[] visited = new boolean[n+1];
        visited[1]=true;
        
        while(!q.isEmpty()){
            int[] nd = q.poll();
            
            if(!edges.containsKey(nd[0])) continue;
            else{
                for(int next : edges.get(nd[0])){
                    if(visited[next]) continue;
                    if(dist[next]<nd[1]+1) continue;
                    dist[next]=nd[1]+1;
                    q.add(new int[]{next,nd[1]+1});
                    visited[next]=true;
                }
            }
        }
        int max=-1;
        int answer=1;
        for(int i=1; i<n+1; i++){
            if(max<dist[i] && dist[i]!=Integer.MAX_VALUE){
                max=dist[i];
                answer=1;
            }
            else if(max==dist[i]) answer++;
            //System.out.println(i+" = "+dist[i]);
        }
        return answer;
    }
}