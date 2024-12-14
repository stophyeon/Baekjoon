import java.util.*;
class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)->{
        if(e1[0]==e2[0]){
            return e2[1]-e1[1];
        }
        return e2[0]-e1[0];
    });
    int n;
    int m;
    int[][] user;
    int[] em;
    public int[] solution(int[][] users, int[] emoticons) {
        n=users.length;
        m=emoticons.length;
        user=users;
        em=emoticons;
        //이모티콘 할인율 경우의 수
        boolean[] visited = new boolean[m];
        for(int i=0; i<m; i++){
            visited[i]=true;
            int[] per = new int[m];
            for(int j=10; j<=40; j+=10){
                per[i]=j;
                backTracking(1,j,visited,per);    
            }
        }
        //해당 경우의 수에 대한 사용자 구매,구독 연산
        
        return pq.poll();
    }
    public void backTracking(int depth,int per,boolean[] visited,int[] percent){
        if(depth==m){
            cal(percent);
            return;
        }
        for(int i=depth; i<m; i++){
            if(visited[i]) continue;
            visited[i]=true;
            for(int j=10; j<=40; j+=10){
                percent[i]=j;
                backTracking(depth+1,j,visited,percent);
            }
            visited[i]=false;
        }
    }
    
    public void cal(int[] per){
        int plus=0;
        int total=0;
        for(int i=0; i<n; i++){
            int[] u = user[i];
            int res=0;
            for(int j=0; j<m; j++){
                if(per[j]>=u[0]){
                    res+=(em[j]/100)*(100-per[j]);
                }
            }
            if(res>=u[1]){
                res=0;
                plus++;
            }
            total+=res;
        }
        pq.add(new int[]{plus,total});
    }
}