import java.util.*;

class Solution {
    //List<String> dic = new ArrayList<>();
    HashMap<String,Integer> dic = new HashMap<>();
    List<Integer> ans  = new ArrayList<>();
    String[] str;
    int idx=0;
    public int[] solution(String msg) {
        //사전 초기화
        char alp = 'A';
        for(int i=1; i<27; i++){
            dic.put(String.valueOf(alp),i);
            //System.out.print(alp+","+dic.get(String.valueOf(alp))+" ");
            alp+=1;
        }
        str=msg.split("");
        //dfs 탐색
        dfs(0,str[0]);
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void dfs(int answer,String msg){
        
        if(!dic.containsKey(msg)){
            ans.add(answer);
            dic.put(msg,dic.size()+1);
            dfs(0,str[idx]);
        }
        else{
            idx++;
            if(idx==str.length){
                ans.add(dic.get(msg));
                return;
            }
            dfs(dic.get(msg),msg+str[idx]);
        }
    }
}