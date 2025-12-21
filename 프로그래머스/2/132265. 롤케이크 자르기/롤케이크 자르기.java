import java.util.*;

class Solution {
    
    int answer = 0;
    int n;
    
    HashMap<Integer,Integer> type1 = new HashMap<>();
    HashMap<Integer,Integer> type2 = new HashMap<>();
    public int solution(int[] topping) {
        n = topping.length;
        
        for(int i=0; i<n; i++){
            type2.put(topping[i],type2.getOrDefault(topping[i],0)+1);
        }
        
        for(int i=0; i<n; i++){
            type1.put(topping[i],type1.getOrDefault(topping[i],0)+1);
            //오른쪽에서 뻼
            type2.put(topping[i], type2.get(topping[i]) - 1);
            
            if (type2.get(topping[i]) == 0) {
                type2.remove(topping[i]);
            }
            
            if(type1.size()==type2.size()) answer++;
        }
        
        return answer;
    }
    
    
}