import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> ans = new ArrayList<>();
        HashMap<String,String> dic = new HashMap<>();
        for(String r : record){
            String[] str = r.split(" ");
            if(!str[0].equals("Leave")){
                dic.put(str[1],str[2]);
            }
            
        }
        for(String r : record){
            String[] str = r.split(" ");
            if(str[0].equals("Enter")) {
                ans.add(dic.get(str[1])+"님이 들어왔습니다.");
            }
            else if(str[0].equals("Leave")){
                ans.add(dic.get(str[1])+"님이 나갔습니다.");
            }
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}