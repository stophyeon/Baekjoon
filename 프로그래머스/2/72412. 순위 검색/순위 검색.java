import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
class Solution {
    HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String in : info){
            String[] arr = in.split(" ");
            dfs(arr,"",0);
        }
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i=0; i<query.length; i++){
            String[] str = query[i].split(" and ");
            String q = str[0]+str[1]+str[2]+str[3].split(" ")[0];
            int score = Integer.parseInt(str[3].split(" ")[1]);
            
            answer[i]=count(q,score);
        }
        return answer;
    }
    public void dfs(String[] arr, String com, int d){
        if(d==4){
            if(map.containsKey(com)){
                map.get(com).add(Integer.parseInt(arr[4]));
                
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(arr[4]));
                map.put(com,list);
            }
            return;
        }
        dfs(arr,com+arr[d],d+1);
        dfs(arr,com+"-",d+1);
    }
    
    public int count(String query, int score){
        if(map.get(query)==null){return 0;}
        ArrayList<Integer> list = map.get(query);
        
        int s=0; 
        int e = list.size()-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(score>list.get(mid)){s=mid+1;}
            else{e=mid-1;}
        }
        
        
        return list.size()-s;
    }
}