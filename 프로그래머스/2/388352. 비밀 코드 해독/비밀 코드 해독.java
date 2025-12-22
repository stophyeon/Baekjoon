import java.util.*;
class Solution {
    int N;
    HashMap<String,Integer> query = new HashMap<>();
    // int[][] query;
    // int[] res;
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        N=n;
        //int answer = 0;
        // query = q;
        // res = ans;
        for(int i=0; i<q.length; i++){
            String str =String.valueOf(q[i][0]);
            for(int j=1; j<5; j++){
                 str+=","+String.valueOf(q[i][j]);
            }
            query.put(str,ans[i]);
         }
        
        for(int i=1; i<=n; i++){
            dfs(1,i,String.valueOf(i));
        }
        return answer;
    }
    
    public void dfs(int depth,int start,String code){
        if(depth==5){
            isPossible(code);
            return;
        }
        else{
          for(int i=start+1; i<=N; i++){
            dfs(depth+1,i,code+","+String.valueOf(i));
          }  
        }
    }
    
    public void isPossible(String code){
        String[] c = code.split(",");
        
        boolean perfect = true;    
        //System.out.println(c[0]);
        for(String key : query.keySet()){
           HashMap<String,Integer> map = new HashMap<>(); 
           String[] k = key.split(",");
           int cnt = 0;
           for(int i=0; i<5; i++){
               map.put(k[i],1);
           }
                
           for(int i=0; i<5; i++){
               if(map.containsKey(c[i])) cnt++;
           }
           //System.out.print(code+" / "+ key + " = " + String.valueOf(cnt) + " / " + query.get(key)); 
           // System.out.println();
           if(query.get(key)!=cnt){perfect = false; break;}  
        }
        if(perfect) answer++;
    }
}