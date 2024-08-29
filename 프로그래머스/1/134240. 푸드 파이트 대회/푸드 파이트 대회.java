import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++){
            if(food[i]%2==1){
                if(food[i]==1){continue;}
                for(int j=0; j<(food[i]-1)/2; j++){
                    sb.append(i);
                }
            }
            else{
                for(int j=0; j<food[i]/2; j++){
                    sb.append(i);
                }
            }
        }
        String p1 = sb.toString();
        String p2 = sb.reverse().toString();
        answer = p1+"0"+p2;
        return answer;
    }
}