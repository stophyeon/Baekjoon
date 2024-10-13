import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int N, int number) {
        int cnt=1; 
        String s = "";
        while(s.length()<=8){
            s+=String.valueOf(N);
            map.put(Integer.parseInt(s),cnt);
            cnt++;
        }
        dfs(N, 0, 0);
        return map.getOrDefault(number, -1);
    }

    public void dfs(int N, int cnt, int current) {
        if (cnt > 8 || (cnt > 0 && current == 0)) {
            return;
        }
        map.put(current, Math.min(map.getOrDefault(current, cnt), cnt));
        int digit = 1;
        for (int i = N; i <= 1111111111; i = i * 10 + N) {
            dfs(N, cnt + digit, current + i);
            dfs(N, cnt + digit, current - i);
            dfs(N, cnt + digit, current * i);
            dfs(N, cnt + digit, current / i);
            digit++;
        }
    }
}