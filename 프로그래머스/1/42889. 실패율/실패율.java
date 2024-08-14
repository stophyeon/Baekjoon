import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer,Double> ans = new HashMap<>();
        for(int i=1; i<=N; i++){
            double per=0.0;
            double cant=0.0;
            for(int stage : stages){
                if(stage>=i) per++;
                if(stage==i) cant++;
            }
            if(per==0) ans.put(i,0.0);
            else{
                
                double p = cant/per;
                ans.put(i,p);
            }
        }
        
        
        List<Integer> list = new ArrayList<>(ans.keySet());
        Collections.sort(list, (v1, v2) -> Double.compare(ans.get(v2),ans.get(v1)));
        int[] answer = list.stream().mapToInt(x->x).toArray();
        return answer;
    }
}