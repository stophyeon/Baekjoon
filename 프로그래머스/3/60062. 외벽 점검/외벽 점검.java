import java.util.*;
class Solution {
    int len;
    int[] w;
    int answer = 100;
    int[] person;
    public int solution(int n, int[] weak, int[] dist) {
        
        len = weak.length;
        person=dist;
        w = new int[2*len-1];
        for(int i=0; i<len; i++){
            w[i]=weak[i];
        }
        for(int i=len; i<2*len-1; i++){
            w[i]=weak[i-len]+n;
        }
        
        for(int i=0; i<len; i++){
            boolean[] visited = new boolean[person.length];
            int[] p = new int[person.length];
            dfs(0,0,visited,i,p);
        }
        if(answer==100) return -1;
        return answer;
    }
    
    public void dfs(int depth, int cnt ,boolean[] visited,int start,int[] p){
        if(depth==person.length) {
            check(p,start); 
            return;
        }
        for(int i=0; i<person.length; i++){
            if(visited[i]) continue;
            visited[i]=true;
            p[cnt]=person[i];
            dfs(depth+1, cnt+1,visited,start,p);
            visited[i]=false;
            p[cnt]=0;
        }
    }
    
    public void check(int[] p, int start){
        int idx=1;
        int res=w[start]+p[0];
        for(int i=start; i<=start+len-1; i++){
            if(res<w[i]){
                idx++;
                if(idx>p.length) return;
                res=w[i]+p[idx-1];
            }
        }
        answer=Math.min(answer,idx);
    }
}