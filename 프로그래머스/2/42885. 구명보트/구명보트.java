import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j= people.length-1;
        boolean[] visited = new boolean[people.length];
        for(int i =0; i < people.length; i++){
            
            if(visited[i]) continue;
            
            while(j>i && people[i]+people[j]>limit) j--;
            if(j>i) {visited[j] = true; j--;}
            visited[i] = true;
            //System.out.println(i+","+j);
            answer++;
            
        }
        return answer;
    }
}