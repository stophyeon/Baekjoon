import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int n,k;
    int[][] store;
    int[][] stage;
    public int solution(int[][] cost, int[][] hint) {
        n=cost.length;
        k=hint[0].length;
        store=hint;
        stage=cost;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n; i++)
            hm.put(i,0);
        dfs(0,hm,0);
        return answer;
    }
    public void dfs(int depth, HashMap<Integer,Integer> hint,int res){
        
        //현재 사용가능한 힌트권
        int point = stage[depth][hint.get(depth)>=n ? n-1 : hint.get(depth)];
        //이번 스테이지에서 힌트번들 구매에 대한 경우의 수
        if(depth==n-1){
            //마지막 스테이지
            answer=Math.min(answer,res+point);
            return;
            
        }else{
            int price = store[depth][0];
            HashMap<Integer,Integer> hint2 = new HashMap<>(hint);
            //힌트번들 구매 X
            dfs(depth+1,hint2,res+point);
            //힌트번들 구매 O
            for(int i=1; i<k; i++){
                hint2.put(store[depth][i]-1,hint2.get(store[depth][i]-1)+1);
            }
            dfs(depth+1,hint2,res+point+price);    
        }
    }
}