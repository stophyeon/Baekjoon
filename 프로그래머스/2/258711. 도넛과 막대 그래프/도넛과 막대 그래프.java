import java.util.*;

class Solution {
    
    HashMap<Integer,List<Integer>> in = new HashMap<>();
    HashMap<Integer,List<Integer>> out = new HashMap<>();
    
    int[] answer = new int[4];
    public int[] solution(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //정점개수
        
        for(int[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0],1);
            if(!map.containsKey(edge[1])) map.put(edge[1],1);
        }
        
        for(int i : map.keySet()){
            in.put(i,new ArrayList<>());
            out.put(i,new ArrayList<>());
        }
        
        for(int[] edge : edges){
            //들어오는 간선
            in.get(edge[1]).add(edge[0]);
            //나가는 간선
            out.get(edge[0]).add(edge[1]);
        }
        
        //무관한 정점 = 나가는 간선만 2개이상인 정점
       for(int i : map.keySet()){
           if(in.get(i).size()==0&&out.get(i).size()>=2) {answer[0]=i; break;}
       }
        
        //각 그래프 개수
        for(int i : map.keySet()){
            if (i == answer[0]) continue;
            if(out.get(i).size()==0) {answer[2]++;}
            else if(in.get(i).size()>=2&&out.get(i).size()==2) answer[3]++;
        }
        answer[1] = out.get(answer[0]).size() - answer[2]-answer[3];
        return answer;
    }
    
     
}