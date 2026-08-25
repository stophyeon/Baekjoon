import java.util.*;

class Solution {
    long p;
    long answer = 0L;
    public int solution(int dist_limit, int split_limit) {
        p = split_limit;
        //깊이, 부모부터 루트까지 자식노드 개수, 현재 깊이 자식노드 개수, 현재까지 리프노드 개수
        dfs(1L, 1L, 0L, dist_limit);
        return (int)answer;
    }
    public void dfs(long cal, long nodeCnt, long leaf, long limit){
        
        if(answer<leaf+nodeCnt) answer=leaf+nodeCnt;
        
        if(limit==0) return;
        
        //경우의 수 
        //현재 깊이에 있는 리프노드 중 분배노드 몇개 선택할지 결정
        long i = Math.min(nodeCnt,limit);
        //자식 노드 개수 2개
        if(cal*2<=p) dfs(cal*2 ,i*2, leaf+nodeCnt-i, limit-i);
        //자식 노드 개수 3개
        if(cal*3<=p) dfs(cal*3 ,i*3, leaf+nodeCnt-i, limit-i);
    }
}