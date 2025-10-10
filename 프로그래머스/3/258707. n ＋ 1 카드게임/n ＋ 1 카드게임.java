import java.util.*;
class Solution {
    int n;
    int answer = 0;
    Queue<Integer> q = new LinkedList<>();
    public int solution(int coin, int[] cards) {
        //카드 뭉치 세팅 
        n =cards.length;
        for(int card : cards){
            q.add(card);
        }
        //n/3장 뽑음
        HashMap<Integer,Integer> hand = new HashMap<>();
        
        for(int i=0; i<n/3; i++){
            hand.put(q.poll(),1);
        }
        
        //시뮬레이션
        dfs(hand,new HashMap<>(),coin,1);
        
        return answer;
    }
    
    public void dfs(HashMap<Integer,Integer> hand,HashMap<Integer,Integer> rest,int coin,int round){
        
        if(q.isEmpty()){
            if(answer<round) answer=round;
            return;
        }
        //2장 뽑음
        int num1 = q.poll();
        int num2 = q.poll();
        
        //뽑은 카드 저장
        rest.put(num1,1);
        rest.put(num2,1);
        
        boolean p1=false;
        boolean p2=false;
        boolean p3=false;
        //뽑은 카드, 손의 카드로 n+1이되는 조합찾기
        for(int k : hand.keySet()){
            if(hand.containsKey(n+1-k)){
                hand.remove(k);
                hand.remove(n+1-k);
                p1=true;
                break;
            }
        }
        if(!p1&&coin>=1){
            for(int k : hand.keySet()){
                if(rest.containsKey(n+1-k)){
                    hand.remove(k);
                    rest.remove(n+1-k);
                    coin--;
                    p2=true;
                    break;
                }
            }
        }
        if(!p1&&!p2&&coin>=2){
            for(int k : rest.keySet()){
                if(rest.containsKey(n+1-k)){
                    rest.remove(k);
                    rest.remove(n+1-k);
                    coin-=2;
                    p3=true;
                    break;
                }
            }
        }
        //카드를 낼 수 없을때
        if(!p1&&!p2&&!p3){
            if(answer<round) answer=round;
            return;
        }
        
        dfs(hand,rest,coin,round+1);
    }
}