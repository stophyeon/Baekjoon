import java.util.*;
import java.util.stream.Collectors;
class Solution {

    public int solution(int[] a) {
        int answer = 0;
        int[] minL = new int[a.length];
        int[] minR = new int[a.length];
        List<Integer> balloon = Arrays.stream(a).boxed().collect(Collectors.toList());
        int min=Integer.MAX_VALUE;
        for(int i=0; i<balloon.size(); i++){
            min=Math.min(balloon.get(i),min);
            minL[i]=min;
        }
        min=Integer.MAX_VALUE;
        for(int i=0; i<balloon.size(); i++){
            min=Math.min(balloon.get(balloon.size()-1-i),min);
            minR[balloon.size()-i-1]=min;
        }
        
        for(int i=0; i<balloon.size(); i++){
            int cnt=0;
            int ml = 0;
            int mr = 0;
            if(i==0) ml=Integer.MAX_VALUE;
            else{ml=minL[i-1];}
            if(i==balloon.size()-1) mr=Integer.MAX_VALUE;
            else{mr=minR[i+1];}
            //System.out.print(ml);
            //System.out.print(",");
            //System.out.println(mr);
            if(balloon.get(i)>ml) cnt++;
            if(balloon.get(i)>mr) cnt++;
            if(cnt<2) answer++;
        }
        
        return answer;
    }
}