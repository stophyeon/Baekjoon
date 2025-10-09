import java.util.*;

class Solution {
    HashMap<String, Integer> route = new HashMap<>();
    HashMap<String, Integer> index = new HashMap<>();
    int answer = 0;
    int[][] record;
    
    public int solution(String[] friends, String[] gifts) {
        int num = friends.length;
        record = new int[num][num];
        
        for(int i=0; i<num; i++){
            route.put(friends[i],0);
            index.put(friends[i],i);
        }
        
        for(String gift : gifts){
            String[] res = gift.split(" ");
            //선물지수 등록
            route.put(res[0],route.get(res[0])+1);
            route.put(res[1],route.get(res[1])-1);
            //선물 주고받은 이력 저장
            record[index.get(res[0])][index.get(res[1])] +=1;
        }
        
        //다음달 받을 선물 계산
        for(int i=0; i< num; i++){
            int gift=0;
            for(int j=0; j<num; j++){
                if(i==j) continue;
                //준 선물이 받은 선물보다 많을 때 다음달에 선물 받음
                if(record[i][j]>record[j][i]) gift++;
                //주고받은 개수가 같을 때 선물지수가 크면 다음달에 선물 받음
                else if(record[i][j]==record[j][i]){
                    if(route.get(friends[i])>route.get(friends[j])) gift++;
                }
            }
            if(gift>answer) answer=gift;
             
        }
        return answer;
    }
}