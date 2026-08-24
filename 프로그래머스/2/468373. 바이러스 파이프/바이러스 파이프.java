import java.util.*;

class Solution {
    
    HashMap<Integer,HashMap<Integer,List<Integer>>> pipe = new HashMap<>();
    int K;
    int answer = 0;
    public int solution(int n, int infection, int[][] edges, int k) {
        
        K=k;
        for(int i=1; i<=n; i++){
            HashMap<Integer,List<Integer>> map = new HashMap<>();
            map.put(1,new ArrayList<>());
            map.put(2,new ArrayList<>());
            map.put(3,new ArrayList<>());
            pipe.put(i,map);
        }
        //1,2,3 - A,B,C
        
        for(int[] e : edges){
            pipe.get(e[0]).get(e[2]).add(e[1]);
            pipe.get(e[1]).get(e[2]).add(e[0]);
        }
        //연쇄
        
        
        
        List<Integer> virus = new ArrayList<>();
        virus.add(infection);
        boolean[] visited = new boolean[n+1];
        visited[infection]=true;
        dfs(0,virus,visited);
        return answer;
    }
    public void dfs(int depth,List<Integer> virus,boolean[] visited){
        if(depth==K){
            //System.out.println(answer);
            if(answer<virus.size()) answer = virus.size();
            return;
        }
        for(int i=1; i<=3; i++){
            List<Integer> list = new ArrayList<>();
            list.addAll(virus);
            List<Integer> reset = new ArrayList<>();
            //System.out.print(i+" = ");
            for(int node : virus){
                Queue<Integer> q = new LinkedList<>();
                q.add(node);
                while(!q.isEmpty()){
                    int nd = q.poll();
                    for(int p : pipe.get(nd).get(i)){
                        if(visited[p]) continue;
                        q.add(p);
                        reset.add(p);
                        list.add(p);
                        visited[p]=true;
                    }
                }
            }
            dfs(depth+1,list,visited);
            for(int r : reset){
                visited[r]=false;
            }
        }
    }
}