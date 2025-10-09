import java.util.*;

class Solution {
    
    HashMap<Integer, Integer> in = new HashMap<>();
    HashMap<Integer, Integer> out = new HashMap<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] answer = new int[4];
    
    public int[] solution(int[][] edges) {
        
        //무관한 정점 찾기
        for(int[] edge : edges){
            if(out.containsKey(edge[0])){
                out.put(edge[0],out.get(edge[0])+1);
            }
            else if(!out.containsKey(edge[0])){
                out.put(edge[0],1);
            }
            if(in.containsKey(edge[1])){
                in.put(edge[1],in.get(edge[1])+1);
            }
            else if(!in.containsKey(edge[1])){
                in.put(edge[1],1);
            }
            if(map.containsKey(edge[0])){
                map.get(edge[0]).add(edge[1]);
            } else if(!map.containsKey(edge[0])){
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0],list);
            }
        }
        for(int k : out.keySet()){
            if(!in.containsKey(k)&&out.get(k)>=2) answer[0]=k;
        }
        //무관한 정점에서 들어오는 간선은 개수에서 제외
        for(int k : map.get(answer[0])){
            in.put(k,in.get(k)-1);
        }
        // for(int k : map.keySet()){
        //     System.out.print(k+" - ");
        //     for(int v : map.get(k)){
        //         System.out.print(v+",");
        //     }
        //     System.out.println();
        // }
        int num2=0;
        int num3=0;
        //들어오는 간선만 있고 나가는 간선이 없는 정점 - 막대
        //나가는 간선2개, 들어오는 간선 2개 - 8자
        for(int k : in.keySet()){
            if(!out.containsKey(k)) num2++;
            else{
                
                if(in.get(k)==2&&out.get(k)==2) num3++;
            }
        }
        
        answer[2]=num2;
        answer[3]=num3;
        //나머지가 도넛
        answer[1]=map.get(answer[0]).size()-(num2+num3);
        
        return answer;
    }
    
    
}