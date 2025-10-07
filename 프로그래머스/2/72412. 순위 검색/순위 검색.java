import java.util.*;
class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0; i<info.length; i++){
            String[] p=info[i].split(" ");
            dfs(p,0, "");
        }
        
        for(String k : map.keySet()){
            Collections.sort(map.get(k));
        }
        
        for(int i=0; i<query.length; i++){
            String[] q = query[i].split(" and ");
            String[] x = q[3].split(" ");
            q[3] = x[0];
            int score = Integer.valueOf(x[1]);
            String key = q[0]+q[1]+q[2]+q[3];
            if(!map.containsKey(key)) continue;
            List<Integer> list = map.get(key);
            //탐색 알고리즘
            
            int left = 0, right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) >= score) right = mid;
                else left = mid + 1;
            }
            answer[i] = list.size() - left;
        }
        return answer;
    }
    
    public void dfs(String[] p,int depth,String res){
        if(depth == 4){
            int score = Integer.valueOf(p[4]);
            if(map.containsKey(res)){
                map.get(res).add(score);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(res,list);
            }
            return;
        }
        String s1 = res+p[depth];
        String s2 = res+"-";
        
        dfs(p,depth+1,s1);
        dfs(p,depth+1,s2);
    }
}