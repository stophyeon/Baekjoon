import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        String[] str = s.split(",");
        for(String res : str){
            String ans ="";
            for(int i=0; i<res.length(); i++){
                if(Character.isDigit(res.charAt(i))){
                    ans+=Character.toString(res.charAt(i));
                    
                }
            }
            map.put(Integer.parseInt(ans),map.getOrDefault(Integer.parseInt(ans),0)+1);
        }
        List<Integer> l = new ArrayList<>(map.keySet());
        l.sort((o1,o2)->map.get(o2)-map.get(o1));
        return l.stream().mapToInt(x->x).toArray();
    }
}