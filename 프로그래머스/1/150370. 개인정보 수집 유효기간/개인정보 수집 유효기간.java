import java.util.*;
class Solution {
    int[] now = new int[3];
    public int[] solution(String today, String[] terms, String[] privacies) {
        now = toInt(today.split("\\."));
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] t = term.split(" ");
            map.put(t[0],Integer.parseInt(t[1]));
        }
        System.out.println(map.size());
        for(int i=0; i<privacies.length; i++){
            String[] s = privacies[i].split(" ");
            int[] until = toInt(s[0].split("\\."));
            if(cal(until,map.get(s[1]))){
                ans.add(i+1);
            }
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] toInt(String[] s){
        int[] nows = new int[3];
        for(int i=0; i<s.length; i++){
            nows[i]=Integer.parseInt(s[i]);
        }
        return nows;
    }
    public boolean cal(int[] num, int n){
        
        int sum = num[0]*28*12+(num[1]+n)*28+num[2]-1;
        int s_now = now[0]*28*12+now[1]*28+now[2];
        
        return sum<s_now;
    }
}