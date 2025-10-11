import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        String[] now = today.split("\\.");
        //연,월,일을 일수로 변경
        int day = Integer.valueOf(now[0])*12*28+Integer.valueOf(now[1])*28+Integer.valueOf(now[2]);
            
        HashMap<String,Integer> type = new HashMap<>();
        //약관 종류별 일수로 변환해 유효기간저장
        for(String term : terms){
            String[] t = term.split(" ");
            type.put(t[0],Integer.valueOf(t[1])*28);
        }
        int idx=1;
        for(String privacy : privacies){
            String[] p = privacy.split(" ");
            String[] date = p[0].split("\\.");
            int cal = Integer.valueOf(date[0])*12*28+Integer.valueOf(date[1])*28+Integer.valueOf(date[2]);
            cal+=type.get(p[1]);
            //System.out.println(cal);
            if(day>=cal) ans.add(idx);
            idx++;
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}