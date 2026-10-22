import java.util.*;
class Solution {
    int min = Integer.MAX_VALUE;
    int total=0;
    int len;
    public int solution(String name) {
        int answer = 0;
        len = name.length();
        List<Integer> rest = new ArrayList<>();
        //글자마다 최소 알파벳 이동 횟수 계산
        int idx=0;
        for(char c : name.toCharArray()){
            int cnt = calDiff(c);
            answer+=cnt;
            if(cnt!=0&&idx!=0){
                total++;
                rest.add(idx);
            }
            idx++;
        }
        //최소 이동횟수 계산
        //현재 위치에서 가장 가까운 목표 탐색 후 분기처리 
        move(0,0, 0,rest, new boolean[len]);
        
        return answer+min;
    }
    public void move(int idx, int cnt,int dis, List<Integer> rest,boolean[] visited){
        if(cnt==total){
            min = Math.min(min,dis);
            return;
        }
        int rightIdx = 0;
        int rightDis = Integer.MAX_VALUE;
        int leftIdx = 0;
        int leftDis = Integer.MAX_VALUE;
       //가장 가까운 거리 계산
        for(int i=0; i<rest.size(); i++){
            if(visited[rest.get(i)]) continue;
            int calR = moveRight(idx,rest.get(i));
            int calL = moveLeft(idx,rest.get(i));
            if(rightDis>calR){
                rightIdx=rest.get(i);
                rightDis=calR;
            }
            if(leftDis>calL){
                leftIdx=rest.get(i);
                leftDis=calL;
            }
        }
        boolean[] visit = Arrays.copyOf(visited,len);
        
        //우측 가장 가까운
        visit[rightIdx]=true;
        move(rightIdx,cnt+1,dis+rightDis,rest,visit);
        visit[rightIdx]=false;
        //좌측 가장 가까운
        visit[leftIdx]=true;
        move(leftIdx,cnt+1,dis+leftDis,rest,visit);
        visit[leftIdx]=false;
    }
    public int moveLeft(int now, int next){
        //왼쪽으로 이동 시
        int left = now-next;
        //한바퀴 돌았을 때
        if(now<next) {
            left +=len;
        }
        return left;
    }
    public int moveRight(int now, int next){
        //오른쪽으로 이동 시
        int right = next-now;
        //한바퀴 돌았을 때
        if(now>next) {
            right +=len;
        }
       
        return right;
    }
    public int calDiff(char c){
        //알파벳 26개 
        int diff = c-'A';
        //반대로 이동하는게 더 짧을 때
        if(diff>13){
            diff='Z'-c+1;
        }
        return diff;
    }
}