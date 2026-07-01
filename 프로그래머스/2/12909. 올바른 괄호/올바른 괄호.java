import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] str = s.split("");
        Stack<String> out = new Stack<>();
        for(String a : str){
            if(a.equals("(")) out.push(a);
            else{
                if(out.isEmpty()) return false;
                out.pop();
            }
        }
        
        if(!out.isEmpty()) return false;
        return answer;
    }
}