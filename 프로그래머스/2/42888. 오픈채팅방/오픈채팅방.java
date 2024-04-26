import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class Solution {
    HashMap<String,String> map = new HashMap<>();
    public String[] solution(String[] record) {
        int n = record.length;
        
        List<String> state = new ArrayList<>();
        
        List<String> uid = new ArrayList<>();
        for(int i =0; i<record.length; i++){
            String[] log = record[i].split(" ");
            if(!log[0].equals("Leave")){map.put(log[1],log[2]);}
            if(!log[0].equals("Change")){uid.add(log[1]);state.add(log[0]);}
            
        }
        String[] st = new String[state.size()];
        for(int i=0; i<state.size(); i++){
            if(state.get(i).equals("Enter")){st[i]="들어왔습니다.";}
            if(state.get(i).equals("Leave")){st[i]="나갔습니다.";}
        }
        String[] answer = new String[state.size()];
        
        for(int i =0; i<uid.size(); i++){
             StringBuilder sb = new StringBuilder();
             sb.append(map.get(uid.get(i))).append("님이 ").append(st[i]);
             answer[i]=sb.toString();
        }
        return answer;
    }
}