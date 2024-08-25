import java.util.*;
class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();
       
        for(int i=0; i<c.length; i++){
            if(Character.isUpperCase(c[i])){
                upper.add(c[i]);
            }
            else{
                lower.add(c[i]);
            }
        }
        Collections.sort(upper,Collections.reverseOrder());
        Collections.sort(lower,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Character l : lower){
            sb.append(l);
        }
        for(Character u : upper){
            sb.append(u);
        }
        
        return sb.toString();
    }
}