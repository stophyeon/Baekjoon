import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<String> set = new HashSet<>();
        String[] skips = skip.split("");
        for(int i=0; i<skips.length; i++){
            set.add(skips[i]);
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j=0; j<index; j++){
                c++;
                if(c=='{') c='a';
                while(set.contains(String.valueOf(c))){
                    c++;
                    if(c=='{') c='a';
                }
            }
            answer+=String.valueOf(c);
        }
        return answer;
    }
}