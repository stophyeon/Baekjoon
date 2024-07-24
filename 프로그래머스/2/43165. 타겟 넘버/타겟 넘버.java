import java.util.*;
class Solution {
    int t;
    int d;
    int answer=0;
    int[] number;
    public int solution(int[] numbers, int target) {
        t=target;
        d=numbers.length;
        number=numbers;
        ArrayList<Integer> list = new ArrayList<>();
        
        dfs(list,0);
        
        return answer;
    }
    public void dfs(ArrayList<Integer> list,int depth){
        if(depth>d) return;
        if(depth==d){
            if(list.stream().mapToInt(i -> i).sum()==t) answer++;
            return;
        }
        ArrayList<Integer> list2 = new ArrayList<>(list);
        list.add(number[depth]);
        list2.add((-1)*number[depth]);
        depth++;
        
        dfs(list,depth);
        dfs(list2,depth);
    }
}