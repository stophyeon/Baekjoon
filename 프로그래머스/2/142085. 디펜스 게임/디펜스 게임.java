import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k>=enemy.length) return enemy.length;
        PriorityQueue<Integer> max = new PriorityQueue<>((n1,n2)->n1-n2);
        for(int i=0; i<enemy.length; i++){
            if(k>0){
                max.add(enemy[i]);
                k--;
                continue;
            }
            int num = max.poll();
            if(enemy[i]>num){
                max.add(enemy[i]);
                n-=num;
            }
            else{
                n-=enemy[i];
                max.add(num);
            }
            if(n<0) {answer=i; break;}
        }
        if(n>=0) return enemy.length;
        return answer;
    }
}