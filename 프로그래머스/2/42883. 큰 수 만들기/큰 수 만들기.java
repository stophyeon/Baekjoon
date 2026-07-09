import java.util.*;
class Solution {
    int[] num;
    String answer = "";
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int len = number.length()-k;
        int start = 0;
        
        
        for(int i=0; i<len; i++){
            int max=-1;
            int maxIdx=start;
            int endBoundary = number.length() - (len - i);
            
            for (int j = start; j <= endBoundary; j++) {
                int currentNum = number.charAt(j) - '0';
                if (max < currentNum) {
                    max = currentNum;
                    maxIdx = j;
                    if (max == 9) break; 
                }
            }
            sb.append(max);
            start = maxIdx + 1;
        }
        
        return sb.toString();
    }
    
    
}