import java.util.*;
class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String,Integer> w = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            w.put(want[i],number[i]);
        }
        for(int i=0; i<discount.length-9; i++){
            int cnt=0;
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=0; j<10; j++){
                if(!map.containsKey(discount[i+j])) map.put(discount[i+j],1);
                else{map.put(discount[i+j],map.get(discount[i+j])+1);}
            }
            
            for(String s : map.keySet()){
                if(!w.containsKey(s)) break;
                if(w.get(s)==map.get(s)) cnt++;
            }
            //for(String k : map.keySet()){
            //    System.out.print(k);
            //    System.out.print("-");
            //    System.out.print(map.get(k));
            //    System.out.print(",");
            //}
            System.out.println();
            if(cnt==want.length) answer++;
            
        }
        return answer;
    }
    
}