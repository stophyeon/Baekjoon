import java.util.*; 
class Solution { 
    int min = 0; 
    int cnt = 0; 
    int[][] map; 
    int A=0; 
    int B=0; 
    HashMap<String,Integer> visit = new HashMap<>();
    public int solution(int[][] info, int n, int m) { 
        int answer = -1; 
        A=n; 
        B=m; 
        min = n; 
        //물건의 총개수 
        cnt = info.length; 
        map=info; 
        
        dfs(0,0,0); 
        if(min!=n) answer = min; 
        return answer; 
    } 
    
    public void dfs(int a, int b, int num){ 
        //모든 물건을 훔쳤을 때 
        if(num==cnt){ 
            if(min > a) min = a; 
            return; 
        } 
        String k = a+","+b+","+num;
        if(visit.containsKey(k)) return;
        //n을 넘지않고 A가 훔쳤을 때 
        if(a+map[num][0]<A) dfs(a+map[num][0],b,num+1); 
        //m을 넘지않고 B가 훔쳤을 때 
        if(b+map[num][1]<B) dfs(a,b+map[num][1],num+1); 
        visit.put(k,0); 
    } 
}