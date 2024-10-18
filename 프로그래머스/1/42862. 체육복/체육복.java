import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        List<Integer> duplicate = new ArrayList<>();
        List<Integer> receiver = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> giver = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        for(int i=0; i<receiver.size(); i++){
            if(giver.contains(receiver.get(i))) duplicate.add(receiver.get(i));
        }
        for(int d : duplicate){
            answer++;
            giver.remove(Integer.valueOf(d));
            receiver.remove(Integer.valueOf(d));
        }
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(giver.contains(i)){
                if(i-1>=0){
                    if(receiver.contains(i-1)&&!visited[i-1]) {answer++;visited[i-1]=true;continue;}
                }
                if(i+1<=n){
                    if(receiver.contains(i+1)&&!visited[i+1]) {answer++;visited[i+1]=true;}
                }
            }
        }
        return answer;
    }
}