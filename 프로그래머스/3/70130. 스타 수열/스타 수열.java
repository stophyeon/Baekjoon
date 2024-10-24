import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        if(a.length<4) return 0;
        
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0; i<a.length; i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        if(map.size()==1) return 0;
        List<Integer> key = new ArrayList<>();
        for(int k : map.keySet()){
            if(map.get(k)==1) continue;
            key.add(k);
        }
        key.sort((k1,k2)->map.get(k2)-map.get(k1));
        for(int k : key){
            if(map.get(k)<=answer) continue;
            int cnt=0;
            for(int i=0; i<a.length-1; i++){
                if(a[i]!=k && a[i+1]!=k) continue;
                if(a[i]==a[i+1]) continue;
                else{cnt++; i++;}
            }
            answer=Math.max(answer,cnt);
        }
        return answer*2;
    }
}